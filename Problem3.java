import java.util.ArrayList;

public class Problem3{
  public static void main(String[] args){
    final int NEW_PRIMES = 1000;
    ArrayList<Integer> primes = Primes.firstPrimes(NEW_PRIMES, null);
    long n = 600851475143L;
    int maxFactor = 1;
    //divide out 2s
    if (n % 2 == 0){
      maxFactor = 2;
      for (; n % 2 == 0 ; n = n / 2);
    }
    for (int i = 3; i <= Math.sqrt(n) ;){
      //if needed, expand list of primes
      if (i == primes.get(primes.size() - 1))
        primes = Primes.firstPrimes(NEW_PRIMES, primes);
      //if factor found then we remember it and divide it out
      if ( n % i == 0){
        maxFactor = i;
        n = n / i;
      }
      else{
        i += 2;
      }
    }
    //as loop stopped when i > Math.sqrt(n) then n is now prime so either
    // MaxFactor or n is the answer
    System.out.println(Math.max(maxFactor,n));
  }
}