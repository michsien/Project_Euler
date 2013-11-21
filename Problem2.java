public class Problem2 {
  public static void main (String[] args){
    final int LIMIT = 4000000;
  
    //Binet's formula is f(n)~fi^n/sqrt(5) which allows to sum our subsequence
    // of the Fibonacci sequence
    
    final double SQRT_OF5 = Math.sqrt(5);
    final double FI = (1 + SQRT_OF5) / 2;
    //even fibs repeat every 3 fibs
    final int CYCLE_LENGTH = 3;
    final long HIGHEST_EVEN_FIB_NUM = Math.round(Math.log(LIMIT * SQRT_OF5) / Math.log(FI));
    final long EVENS = HIGHEST_EVEN_FIB_NUM / CYCLE_LENGTH;

    final double RATIO = Math.pow(FI, CYCLE_LENGTH);
    final double FIRST_EVEN = Math.pow(FI, 3) / SQRT_OF5;
  
    //geometric series
    long result = Math.round(FIRST_EVEN * (1 - Math.pow(RATIO, EVENS)) / (1 - RATIO));
    System.out.println(result);
  }
} 
