import java.util.Scanner;

public class Problem1 {
  public static void main (String[] args){
    final int num1 = 3;
    final int num2 = 5;
    System.out.println("Please provide limit for the calculations:");
    Scanner sc = new Scanner(System.in);
    final int limit = sc.nextInt();
    System.out.println("The sum of multiples of 3 or 5 below limit is:");
    int sum = 0;
    if (limit >= num1)
      sum += sumsequence(limit, num1);
    if (limit >= num2)
      sum += sumsequence(limit, num2);
    if (limit >= num1 * num2);
      sum -= sumsequence(limit, num1 * num2);
    System.out.println(sum);
  }

  private static int sumsequence(int limit, int x){
    assert limit >= x;
    int a_1 = x;
    int a_n = biggestMultiple(limit, x);
    int n   = (a_n - a_1) / x + 1;
    return n * (a_1 + a_n) / 2;
  }

  private static int biggestMultiple(int limit, int x){
    int i = limit - 1;
    for (;i % x != 0; i--);
    return i;
  }

}
