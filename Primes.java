import java.util.ArrayList;

public class Primes{
  //assumes that provided list consists of first n primes
  public static ArrayList<Integer> firstPrimes (final int LIMIT, 
                                                ArrayList<Integer> primes){
  assert LIMIT > 1 : "Finding less than 2 first primes is no fun";
    if (primes == null)
      primes = new ArrayList<Integer>(0);
    if (primes.size() == 0){
      primes.add(2);
      primes.add(3);
    }
    outer: for (int i = primes.get(primes.size() - 1) + 2; primes.size() < LIMIT;
                                   i += 2){
      for (int j = 0; primes.get(j) <= (int) Math.sqrt(i); j++){
        if (i % primes.get(j) == 0)
          continue outer;
      }
      primes.add(i);
    }
    return primes;
  }
  //assumes that provided list consists of first n primes
  public static ArrayList<Integer> primesUpTo (final int LIMIT,
                                               ArrayList<Integer> primes){
  assert LIMIT > 2 : "Primes upto 2 you can check on wikipedia...";
    if (primes == null)
      primes = new ArrayList<Integer>(0);
    if (primes.size() == 0){
      primes.add(2);
      primes.add(3);
    }
    outer: for (int i = primes.get(primes.size() - 1) + 2; 
                primes.get(primes.size() - 1) < LIMIT; i += 2){
      for (int j = 0; primes.get(j) <= (int) Math.sqrt(i); j++){
        if (i % primes.get(j) == 0)
          continue outer;
      }
      if (i <= LIMIT)
        primes.add(i);
      else
        break;
    }
    return primes;
  }

}
