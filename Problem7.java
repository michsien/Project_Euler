import java.util.ArrayList;

public class Problem7{
  public static void main(String[] args){
    final int LIMIT = 10001;
    ArrayList<Integer> primes = Primes.firstPrimes(LIMIT, null);
    final int prime = primes.get(primes.size() - 1);
    System.out.println(prime);
  }

}
