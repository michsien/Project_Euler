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
    final int LIMIT = sc.nextInt();
    System.out.println("The sum of multiples of 3 or 5 below limit is:");
    int sum = 0;
    if (LIMIT > NUM1)
      sum += sumsequence(LIMIT, NUM1);
    if (LIMIT > NUM2)
      sum += sumsequence(LIMIT, NUM2);
    if (LIMIT > NUM1 * NUM2);
      sum -= sumsequence(LIMIT, NUM1 * NUM2);
    System.out.println(sum);
  }

  private static int sumsequence(final int LIMIT, final int X) {
    final int a_1 = X;
    final int a_n = biggestMultiple(LIMIT, X);
    final int n   = (a_n - a_1) / X + 1;
    return n * (a_1 + a_n) / 2;
  }

  private static int biggestMultiple(final int LIMIT, final int X) {
    int i = LIMIT - 1;
    for (;i % X != 0; i--);
    return i;
  }

// Problem 2 : Sum the even fibonacci numbers not greater than LIMIT

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
    final double FIRST_EVEN = Math.pow(FI, 3) / SQRT_OF5;

    //partial sum of geometric series
    long result = Math.round(FIRST_EVEN * (1 - Math.pow(RATIO, EVENS)) /
                  (1 - RATIO));
    System.out.println(result);
  }

// Problem 3 : Find greatest prime factor of certain n

  public static void problem3() {
    final int NEW_PRIMES = 1000;
    ArrayList<Integer> primes = Primes.firstPrimes(NEW_PRIMES, null);
    long n = 600851475143L;
    int maxFactor = 1;
    //divide out 2s (simplifies the for loop)
    if (n % 2 == 0) {
      maxFactor = 2;
      for (; n % 2 == 0 ; n = n / 2);
    }
    for (int i = 3; i <= Math.sqrt(n) ;) {
      //if needed, expand list of primes
      if (i == primes.get(primes.size() - 1))
        primes = Primes.firstPrimes(NEW_PRIMES, primes);
      //if factor found then we remember it and divide it out
      if ( n % i == 0) {
        maxFactor = i;
        n = n / i;
      }
      else {
        i += 2;
      }
    }
    //as loop stopped when i > Math.sqrt(n) then n is now prime so either
    // MaxFactor or n is the answer
    System.out.println(Math.max(maxFactor,n));
  }

// Problem 4 : Calculates greatest palindorm produced by two 3-digit integers

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
    ArrayList<Integer> digits = new ArrayList<Integer>(0);
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

// Problem 5 : Calculates least common multiple of numbers 1,2,...,20

  public static void problem5() {
    final int LIMIT = 20;
    final ArrayList<Integer> primes = Primes.primesUpTo(LIMIT, null);
    int result = 1;
    //each prime in range 1-20 appears n times in factorisation of result, where
    //for prime p the number n is greatest integer such that p^n<=20
    for (int i = 0; i < primes.size(); i++) {
      int j = 1;
      for (; Math.pow(primes.get(i), j) <= LIMIT; j++) {}
      result *= Math.pow(primes.get(i), j - 1);
    }
    System.out.println(result);
  }

// Problem 6 : Calculates difference between square of sum of first n natural 
// numbers and sum of squares of first n natural naumbers

  public static void problem6() {
    final float n = 100f;
    //square of sum of first n natural numbers: (n(n+1)/2)^2
    //sum of squares of first n natural naumbers: n(n+1)(2n+1)/6
    //simplified formula for the difference:(n^2-1)(n^2/4 + n/6)
    int result = Math.round((n * n - 1) * (n * n / 4 + n / 6));
    System.out.println(result);
  }

// Problem 7 : Calculates last prime of first LIMIT primes

  public static void problem7() {
    final int LIMIT = 10001;
    ArrayList<Integer> primes = Primes.firstPrimes(LIMIT, null);
    final int prime = primes.get(primes.size() - 1);
    System.out.println(prime);
  }

// Problem 8 :

  public static void problem8() {
  }

// Problem 9 :

  public static void problem9() {
  }

// Problem 10 :

  public static void problem10() {
  }

}