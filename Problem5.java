import java.util.ArrayList;

//least common multiple of numbers 1,2,3,...,20
public class Problem5{

  private static final ArrayList<Integer> primes = Primes.firstPrimes(100, null);
  private static final int LIMIT = 20;

  public static void main(String[] args){
    int currentLCM = 1;
    for (int i = 1; i <= LIMIT; i++){
      currentLCM = lcm(currentLCM, i);
    }
    System.out.println(currentLCM);
  }

  private static int lcm(final int a, final int b){
    int x = a;
    int y = b;
    for (int i = 0; primes.get(i) <= Math.min(x, y);){
      int j = primes.get(i);
      if (x % j == 0 && y % j == 0){
        x = x / j;
        y = y / j;
      }
      else{
        i++;
      }
    }
    return a * y;
  }

}
