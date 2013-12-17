import java.util.Scanner;
import java.math.BigInteger;
import java.util.ArrayList;

public class Problems21_30 {

  private final static int BASE = 10;


  public static void main(String[] args) {
    System.out.println("Choose the number of the problem to be solved(11-20):");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    switch (number) {
      case 21  : problem21(); break;
      case 22  : problem22(); break;
      case 23  : problem23(); break;
      case 24  : problem24(); break;
      case 25  : problem25(); break;
      case 26  : problem26(); break;
      case 27  : problem27(); break;
      case 28  : problem28(); break;
      case 29  : problem29(); break;
      case 30  : problem30(); break;
      default  : System.out.println("This number out the scope. Bye."); return;
    }
  }

// Problem 21 : "Evaluate the sum of all the amicable numbers under 10000"

  public static void problem21() {
    final int RANGE = 10000;
    ArrayList<Integer> primes = Primes.primesUpTo((int) Math.sqrt(RANGE), null);
    int result = 0;
    for (int i = 1; i <= RANGE; i++) {
      int sumOfDivisors = sumOfProperDivisors(i, primes);
      if (i >= sumOfDivisors)
        continue;
      int sumOfDivisors2 = sumOfProperDivisors(sumOfDivisors, primes);
      if (sumOfDivisors2 == i)
        result += sumOfDivisors + sumOfDivisors2;

    }
    System.out.println(result);
  }

// Problem 22 :

  public static void problem22() {
  }

// Problem 23 : "Find the sum of all the positive integers which cannot be
// written as the sum of two abundant numbers." ("By mathematical analysis, it
// can be shown that all integers greater than 28123 can be written as the sum
// of two abundant numbers.")

  public static void problem23() {
    final int LIMIT = 28123;
    boolean[] abundantNum = new boolean[LIMIT + 1];
    for (int i = 0; i < abundantNum.length; i++) {
      abundantNum[i] = false;
    }
    ArrayList<Integer> primes = Primes.primesUpTo((int) Math.sqrt(LIMIT), null);
    //checking which integers are 'abundant' (i.e. sum of their proper divisors
    //exceeds their value)
    for (int i = 1; i < abundantNum.length; i++) {
      if (sumOfProperDivisors(i, primes) > i)
        abundantNum[i] = true;
    }
    //summing numbers that cannot be represented as sum of two abundant integers
    int result = 0;
    outer: for (int i = 1; i <= LIMIT; i++) {
      for (int j = 1; j <= i / 2; j++) {
        if (abundantNum[j] && abundantNum[i - j])
          continue outer;
      }
      result += i;
    }
    System.out.println(result);
  }

  private static int sumOfProperDivisors(int i, ArrayList<Integer> primes) {
    final int NEW_PRIMES = 100;
    int highestPossiblePrime = (int) Math.sqrt(i);
    int sum = 1;
    int currentNumber = i;
    for (int j = 0; ; j++) {
      //adding primes if needed
      if (j == primes.size() - 1)
        primes = Primes.firstPrimes(NEW_PRIMES, primes);
      int prime = primes.get(j);
      if (prime > highestPossiblePrime)
        break;
      if (currentNumber % prime != 0)
        continue;
      int power = 0;
      while (currentNumber % prime == 0) {
        currentNumber /= prime;
        power++;
      }
      sum *= (1 - Math.pow(prime, power + 1)) / (1 - prime);
    }
    //correction, as there may have remained one prime factor (greater than
    //(int) Math.sqrt(i))
    if (currentNumber != 1)
      sum *= currentNumber + 1;
    //correction as the algorithm counts also the number itself as a divisor
    sum -= i;
    return sum;
  }

// Problem 24 : "What is the millionth lexicographic permutation of the digits 
// 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?"

  public static void problem24() {
    //algorithm assumes that there are at least target available permutations
    int target = 1000000;
    boolean[] usedDigits = new boolean[BASE];
    //initialising table
    for (int i = 0; i < usedDigits.length; i++) {
      usedDigits[i] = false;
    }
    //counting all permutations
    int permutations = 1;
    for (int i = BASE; i > 1; i--) {
      permutations *= i;
    }
    //printing result
    for (int i = BASE; i > 0; i--) {
      permutations /= i; 
      int digit = target / permutations;
      target = target % permutations;
      //correction for exception
      if (target == 0) {
        digit--;
      }
      //printing appropriate digit
      int available = -1;
      for (int j = 0; j < usedDigits.length; j++) {
        if (!usedDigits[j])
          available++;
        if (available == digit) {
          usedDigits[j] = true;
          System.out.print(j);
          break;
        }
      }
      //handling exception
      if (target == 0) {
        for (int j = usedDigits.length - 1; j >= 0; j--) {
          if (!usedDigits[j])
            System.out.print(j);
        }
        break;
      }
    }
    System.out.println();
  }

// Problem 25 : "What is the first term in the Fibonacci sequence to contain 
// 1000 digits?" (meaning - WHICH one is the first..)

  public static void problem25() {
    //Binet's formula is f(n)~fi^n/sqrt(5)
    //first number with at east 1000 digits is 10^999

    final double SQRT_OF5 = Math.sqrt(5);
    final double FI = (1 + SQRT_OF5) / 2;
    final int POWER = 999;
    int result = (int) ((POWER * Math.log(BASE) + Math.log(SQRT_OF5)) / 
                       Math.log(FI)) + 1;
    System.out.println(result);
  }

// Problem 26 :

  public static void problem26() {
  }

// Problem 27 :

  public static void problem27() {
  }

// Problem 28 :

  public static void problem28() {
  }

// Problem 29 :

  public static void problem29() {
  }

// Problem 30 :

  public static void problem30() {
  }




}