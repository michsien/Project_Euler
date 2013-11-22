import java.util.ArrayList;

//least common multiple of numbers 1,2,3,...,20
public class Problem5{
  
  public static void main(String[] args){
    final int LIMIT = 20;
    final ArrayList<Integer> primes = Primes.primesUpTo(LIMIT, null);
    int result = 1;
    for (int i = 0; i < primes.size(); i++){
      int j = 1;
      for (; Math.pow(primes.get(i), j) <= LIMIT; j++){}
      result *= Math.pow(primes.get(i), j - 1);
    }
    System.out.println(result);
  }
}
