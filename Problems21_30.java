import java.util.Scanner;
import java.math.BigInteger;

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

// Problem 21 :

  public static void problem21() {
  }

// Problem 22 :

  public static void problem22() {
  }

// Problem 23 :

  public static void problem23() {
  }

// Problem 24 :

  public static void problem24() {
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