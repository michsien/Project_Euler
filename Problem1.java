import java.util.Scanner;

public class Problem1 {
  public static void main (String[] args){
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

  private static int sumsequence(final int LIMIT, final int X){
    int a_1 = X;
    int a_n = biggestMultiple(LIMIT, X);
    int n   = (a_n - a_1) / X + 1;
    return n * (a_1 + a_n) / 2;
  }

  private static int biggestMultiple(final int LIMIT, final int X){
    int i = LIMIT - 1;
    for (;i % X != 0; i--);
    return i;
  }

}
