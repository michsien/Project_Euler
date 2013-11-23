public class Problem6{
  //Calculate difference between square of sum of first n natural numbers
  //and sum of squares of first n natural naumbers
  public static void main(String[] args){
    final float n = 100f;
    //square of sum of first n natural numbers: (n(n+1)/2)^2
    //sum of squares of first n natural naumbers: n(n+1)(2n+1)/6
    //simplified formula for the difference:(n^2-1)(n^2/4 + n/6)
    int result = Math.round((n * n - 1) * (n * n / 4 + n / 6));
    System.out.println(result);
  }


}