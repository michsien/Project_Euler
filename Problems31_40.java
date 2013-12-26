import java.util.Scanner;

public class Problems31_40 {

  private final static int BASE = 10;


  public static void main(String[] args) {
    System.out.println("Choose the number of the problem to be solved(11-20):");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    switch (number) {
      case 31  : problem31(); break;
      case 32  : problem32(); break;
      case 33  : problem33(); break;
      case 34  : problem34(); break;
      case 35  : problem35(); break;
      case 36  : problem36(); break;
      case 37  : problem37(); break;
      case 38  : problem38(); break;
      case 39  : problem39(); break;
      case 40  : problem40(); break;
      default  : System.out.println("This number out the scope. Bye."); return;
    }
  }


// Problem 31 :

  public static void problem31() {
  }


// Problem 32 :

  public static void problem32() {
  }



// Problem 33 :

  public static void problem33() {
  }



// Problem 34 : "Find the sum of all numbers which are equal to the sum of the
// factorial of their digits. Note: as 1! = 1 and 2! = 2 are not sums they are
// not included."

  public static void problem34() {
    final int MAX_VAL_FROM_DIGIT = factorial(BASE - 1);
    //we need to find the range of numbers which values do not exceed 
    //N*MAX_VAL_FROM_DIGIT where N is the number of digits of a given number
    int limitingPower;
    for (limitingPower = 1; Math.pow(BASE, limitingPower - 1) <= 
        MAX_VAL_FROM_DIGIT * limitingPower; limitingPower++);
    limitingPower--;
    //we remember values of factorials of digits
    int[] digitFactorials = new int[BASE];
    for (int i = 0; i < digitFactorials.length; i++) {
      digitFactorials[i] = factorial(i);
    }
    long result = 0;
    //we start from BASE as otherwise we would have only one digit numbers-could
    //not count them as we would not have sums of factorials of digits
    for (long i = BASE; i < Math.pow(BASE, limitingPower); i++) {
      if (i == sumOfFactorialsOfDigits(i, digitFactorials))
        result += i;
    }
    System.out.println(result);
  }

  private static int factorial(int n) {
    return (n <= 1) ? 1 : n * factorial(n - 1);
  }

  private static long sumOfFactorialsOfDigits(long n, int[] digitFactorials) {
    long sum = 0;
    while (n >= BASE) {
      sum += digitFactorials[(int) n % BASE];
      n /= BASE;
    }
    sum += digitFactorials[(int) n];
    return sum;
  }


// Problem 35 :

  public static void problem35() {
  }



// Problem 36 :

  public static void problem36() {
  }



// Problem 37 :

  public static void problem37() {
  }



// Problem 38 :

  public static void problem38() {
  }



// Problem 39 :

  public static void problem39() {
  }



// Problem 40 :

  public static void problem40() {
  }



}