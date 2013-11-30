import java.util.Scanner;
import java.util.ArrayList;

public class Problems1_10{

  private static final int BASE = 10;

  public static void main(String[] args) {
    System.out.println("Choose the number of the problem to be solved(1-10):");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    switch (number) {
      case 1  : problem1(); break;
      case 2  : problem2(); break;
      case 3  : problem3(); break;
      case 4  : problem4(); break;
      case 5  : problem5(); break;
      case 6  : problem6(); break;
      case 7  : problem7(); break;
      case 8  : problem8(); break;
      case 9  : problem9(); break;
      case 10 : problem10(); break;
      default : System.out.println("This number out the scope. Bye."); return;
    }
  }

// Problem 1 : Caculate sum of multiples of 3 or 5 below provided limit.

  public static void problem1() {
    final int NUM1 = 3;
    final int NUM2 = 5;
    System.out.println("Please provide limit for the calculations:");
    Scanner sc = new Scanner(System.in);
    final int limit = sc.nextInt();
    System.out.println("The sum of multiples of 3 or 5 below limit is:");
    int sum = 0;
    if (limit > NUM1)
      sum += sumsequence(limit, NUM1);
    if (limit > NUM2)
      sum += sumsequence(limit, NUM2);
    if (limit > NUM1 * NUM2);
      sum -= sumsequence(limit, NUM1 * NUM2);
    System.out.println(sum);
  }

  private static int sumsequence(final int limit, final int x) {
    final int a_1 = x;
    final int a_n = biggestMultiple(limit, x);
    final int n   = (a_n - a_1) / x + 1;
    return n * (a_1 + a_n) / 2;
  }

  private static int biggestMultiple(final int limit, final int x) {
    int i = limit - 1;
    for (;i % x != 0; i--);
    return i;
  }

// Problem 2 : Sum the even Fibonacci numbers not greater than LIMIT > 0

  public static void problem2() {
    final int LIMIT = 4000000;

    //Binet's formula is f(n)~fi^n/sqrt(5) which allows to sum our subsequence
    // of the Fibonacci sequence

    final double SQRT_OF5 = Math.sqrt(5);
    final double FI = (1 + SQRT_OF5) / 2;
    //even fibs repeat every 3 fibs
    final int CYCLE_LENGTH = 3;
    final long HIGHEST_EVEN_FIB_NUM = Math.round(Math.log(LIMIT * SQRT_OF5) /
                                      Math.log(FI));
    final long EVENS = HIGHEST_EVEN_FIB_NUM / CYCLE_LENGTH;

    final double RATIO = Math.pow(FI, CYCLE_LENGTH);
    final int FIRST_EVEN_NUM = 3;
    final double FIRST_EVEN_VAL = Math.pow(FI, FIRST_EVEN_NUM) / SQRT_OF5;

    //partial sum of geometric series
    long result = Math.round(FIRST_EVEN_VAL * (1 - Math.pow(RATIO, EVENS)) /
                  (1 - RATIO));
    System.out.println(result);
  }

// Problem 3 : Find greatest prime factor of certain natural number n >= 2

  public static void problem3() {
    final int NEW_PRIMES = 100;
    ArrayList<Integer> primes = Primes.firstPrimes(NEW_PRIMES, null);
    long n = 600851475143L;
    int maxFactor = 1;
    for (int i = 0; primes.get(i) <= Math.sqrt(n) ;) {
      //if needed, expand list of primes
      if (i == primes.size() - 1)
        primes = Primes.firstPrimes(NEW_PRIMES, primes);
      int prime = primes.get(i);
      //if factor found then we remember it and divide it out
      if ( n % prime == 0) {
        maxFactor = prime;
        n = n / prime;
      }
      else {
        i ++;
      }
    }
    //as loop stopped when i > Math.sqrt(n) then n is now prime so either
    // MaxFactor or n is the answer
    System.out.println(Math.max(maxFactor,n));
  }

// Problem 4 : Calculate greatest palindrom produced by two 3-digit integers

  public static void problem4() {
    final int UPPER_LIMIT = 999;
    final int LOWER_LIMIT = 100;
    int largestPalindrom = 1;
    for (int i = UPPER_LIMIT; i >= LOWER_LIMIT; i--) {
      if (i * i < largestPalindrom)
        break;
      for (int j = i; j >= LOWER_LIMIT; j--) {
        if (palindrom(i * j) && i * j > largestPalindrom)
          largestPalindrom = i * j; 
      }
    }
    System.out.println(largestPalindrom);
  }

  private static boolean palindrom(int n) {
    final ArrayList<Integer> digits = new ArrayList<Integer>(0);
    while (n >= BASE) {
      digits.add(n % BASE);
      n = n / BASE;
    }
    digits.add(n);
    int i = 0;
    int j = digits.size() - 1;
    while (j > i) {
      if (digits.get(i) != digits.get(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

// Problem 5 : Calculate least common multiple of numbers 1,2,...,LIMIT

  public static void problem5() {
    final int LIMIT = 20;
    final ArrayList<Integer> primes = Primes.primesUpTo(LIMIT, null);
    int result = 1;
    //each prime in range 1-LIMIT appears n times in factorisation of result, 
    //where for prime p the number n is greatest integer such that p^n<=LIMIT
    for (int i = 0; i < primes.size(); i++) {
      int j = 1;
      for (; Math.pow(primes.get(i), j) <= LIMIT; j++) {}
      result *= Math.pow(primes.get(i), j - 1);
    }
    System.out.println(result);
  }

// Problem 6 : Calculate difference between square of sum of first n natural 
// numbers and sum of squares of first n natural naumbers

  public static void problem6() {
    final float N = 100f;
    //square of sum of first n natural numbers: (n(n+1)/2)^2
    //sum of squares of first n natural naumbers: n(n+1)(2n+1)/6
    //simplified formula for the difference:(n^2-1)(n^2/4 + n/6)
    int result = Math.round((N * N - 1) * (N * N / 4 + N / 6));
    System.out.println(result);
  }

// Problem 7 : Calculate last prime of first LIMIT primes

  public static void problem7() {
    final int LIMIT = 10001;
    final ArrayList<Integer> primes = Primes.firstPrimes(LIMIT, null);
    final int prime = primes.get(primes.size() - 1);
    System.out.println(prime);
  }

// Problem 8 : Find the greatest product of DIGITS consecutive digits in the 
// given number NUM

  public static void problem8() {
    final String NUM = "73167176531330624919225119674426574742355349194934"
                      + "96983520312774506326239578318016984801869478851843"
                      + "85861560789112949495459501737958331952853208805511"
                      + "12540698747158523863050715693290963295227443043557"
                      + "66896648950445244523161731856403098711121722383113"
                      + "62229893423380308135336276614282806444486645238749"
                      + "30358907296290491560440772390713810515859307960866"
                      + "70172427121883998797908792274921901699720888093776"
                      + "65727333001053367881220235421809751254540594752243"
                      + "52584907711670556013604839586446706324415722155397"
                      + "53697817977846174064955149290862569321978468622482"
                      + "83972241375657056057490261407972968652414535100474"
                      + "82166370484403199890008895243450658541227588666881"
                      + "16427171479924442928230863465674813919123162824586"
                      + "17866458359124566529476545682848912883142607690042"
                      + "24219022671055626321111109370544217506941658960408"
                      + "07198403850962455444362981230987879927244284909188"
                      + "84580156166097919133875499200524063689912560717606"
                      + "05886116467109405077541002256983155200055935729725"
                      + "71636269561882670428252483600823257530420752963450";
    final int DIGITS = 5;
    if (DIGITS > NUM.length()) {
      System.out.println("Not enough digits in the number.");
      return;
    }
    if (DIGITS <= 0) {
      System.out.println("Product impossible to calculate.");
      return;
    }
    int current = 1;
    for (int i = 0; i < DIGITS; i++) {
      current *= digit(NUM.charAt(i));
    }
    int max = current;
    for (int i = DIGITS; i < NUM.length(); i++) {
      if (digit(NUM.charAt(i - DIGITS)) != 0)
        current = current * digit(NUM.charAt(i)) / digit(NUM.charAt(i - DIGITS));
      else {
        current = 1;
        for (int j = 0; j < DIGITS; j++) {
          current *= digit(NUM.charAt(i - j));
        }
      }
      if (current > max)
        max = current;
    }
    System.out.println(max);
  }

  private static int digit(char c) {
    return c - '0';
  }

// Problem 9 : Fing a Pythagorean triplet a < b < c for which a + b + c = TARGET

  public static void problem9() {
   final int TARGET = 1000;
   final int SMALLEST_C = ((int) TARGET / 3) + 1;
   final int GREATEST_C = ((int) TARGET / 2) - 1;
   int a = 0;
   int b = 0;
   int c = 0;
   outer: for (int i = SMALLEST_C; i <= GREATEST_C; i++) {
     for (int j = 1 + ((int) (TARGET - i) / 2); j < i; j++) {
       if (i * i == j * j + Math.pow((TARGET - i - j), 2)) {
         c = i;
         b = j;
         a = TARGET - i - j;
         break outer;
       }
     }
   }
   System.out.println(a*b*c);
  }

// Problem 10 : Calculate sum of primes below LIMIT

  public static void problem10() {
    final int LIMIT = 2000000;
    final ArrayList<Integer> primes = Primes.primesUpTo(LIMIT - 1, null);
    long result = 0L;
    for (int i = 0; i < primes.size(); i++) {
      result += primes.get(i);
    }
    System.out.println(result);
  }

}
