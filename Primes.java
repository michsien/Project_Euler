import java.util.ArrayList;

public class Primes{
  //assumes that provided list consists of first n primes
  //adds netx limit primes to the list
  public static ArrayList<Integer> firstPrimes (final long limit, 
                                                ArrayList<Integer> primes){
    assert limit > 1 : "Finding less than 2 first primes is no fun";
    if (primes == null)
      primes = new ArrayList<Integer>(0);
    final int initialSize = primes.size();
    if (primes.size() == 0){
      primes.add(2);
      primes.add(3);
    }
    outer: for (int i = primes.get(primes.size() - 1) + 2; primes.size() < 
                                   initialSize + limit; i += 2){
      for (int j = 0; primes.get(j) <= (int) Math.sqrt(i); j++){
        if (i % primes.get(j) == 0)
          continue outer;
      }
      primes.add(i);
    }
    return primes;
  }
  //assumes that provided list consists of first n primes
  //adds primes to th list until greatest primes in the list reaches limit
  public static ArrayList<Integer> primesUpTo (final long limit,
                                               ArrayList<Integer> primes){
    assert limit > 2 : "Primes upto 2 you can check on wikipedia...";
    if (primes == null)
      primes = new ArrayList<Integer>(0);
    if (primes.size() == 0){
      primes.add(2);
      primes.add(3);
    }
    outer: for (int i = primes.get(primes.size() - 1) + 2; 
                primes.get(primes.size() - 1) < limit; i += 2){
      for (int j = 0; primes.get(j) <= (int) Math.sqrt(i); j++){
        if (i % primes.get(j) == 0)
          continue outer;
      }
      if (i <= limit)
        primes.add(i);
      else
        break;
    }
    return primes;
  }

}
