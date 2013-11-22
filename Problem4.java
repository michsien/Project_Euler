import java.util.ArrayList;

//calculates greates palindorm produced by two 3-digit integers
public class Problem4{

  private static final int BASE = 10;

  public static void main(String[] args){
    int largestPalindrom = 101 * 101;
    for (int i = 999; i >= 100; i--){
      if (i * i < largestPalindrom)
        break;
      for (int j = i; j >= 100; j--){
        if (palindrom(i * j) && i * j > largestPalindrom)
          largestPalindrom = i * j; 
      }
    }
    System.out.println(largestPalindrom);
  }

  private static boolean palindrom(int n){
    ArrayList<Integer> digits = new ArrayList<Integer>(0);
    while (n >= BASE){
      digits.add(n % BASE);
      n = n / BASE;
    }
    digits.add(n);
    int i = 0;
    int j = digits.size() - 1;
    while (j > i){
      if (digits.get(i) != digits.get(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

}
