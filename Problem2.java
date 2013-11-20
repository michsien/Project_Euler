public class Problem2 {
  public static void main (String[] args){
    final int limit = 4000000;
  
    //Binet's formula is f(n)~fi^n/sqrt(5) which allows to sum our subsequence
    // of the Fibonacci sequence
    
    final double sqrtOf5 = Math.sqrt(5);
    final double fi = (1 + sqrtOf5) / 2;
    //even fibs repeat every 3 fibs
    final int cycleLength = 3;
    final long highestEvenFibNum = Math.round(Math.log(limit * sqrtOf5) / Math.log(fi));
    final long evens = highestEvenFibNum / cycleLength;

    final double ratio = Math.pow(fi, cycleLength);
    final double firstEven = Math.pow(fi, 3) / sqrtOf5;
  
    //geometric series
    long result = Math.round(firstEven * (1 - Math.pow(ratio, evens)) / (1 - ratio));
    System.out.println(result);
  }
} 
