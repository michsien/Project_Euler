import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;

public class Problems11_20{

  private static final int BASE = 10;
  private static final int CENTURY = 100;
  private static final int YEARS_BETWEEN_LEAP_YEARS = 4;
  private static final int WEEK_LENGTH = 7;

  public static void main(String[] args) {
    System.out.println("Choose the number of the problem to be solved(11-20):");
    Scanner sc = new Scanner(System.in);
    int number = sc.nextInt();
    switch (number) {
      case 11  : problem11(); break;
      case 12  : problem12(); break;
      case 13  : problem13(); break;
      case 14  : problem14(); break;
      case 15  : problem15(); break;
      case 16  : problem16(); break;
      case 17  : problem17(); break;
      case 18  : problem18(); break;
      case 19  : problem19(); break;
      case 20  : problem20(); break;
      default  : System.out.println("This number out the scope. Bye."); return;
    }
  }

// Problem 11 :

  public static void problem11() {
  }

// Problem 12 : Find the value of first triangle number that has more than
// TARGET divisors

  public static void problem12() {
    final int NEW_PRIMES = 100;
    ArrayList<Integer> primes = Primes.firstPrimes(NEW_PRIMES, null);
    final int TARGET = 500;
    long n = 0;
    int divisors = 1;
    while (divisors <= TARGET) {
      n++;
      divisors = 1;
      long m = n * (n + 1) / 2;
      for (int i = 0; m > 1; i++) {
        //if needed, expand list of primes
        if (i == primes.size() - 1)
          primes = Primes.firstPrimes(NEW_PRIMES, primes);
        //count the appearances of currentPrime in factorisation of m
        int count = 0;
        int currentPrime = primes.get(i);
        while (m % currentPrime == 0) {
          m /= currentPrime;
          count++;
        }
        divisors *= count + 1;
      }
    }
    System.out.println( n * (n + 1) / 2);
  }

// Problem 13 : Find first NUM_OF_DIGITS digits of a sum of a list of 
// equally-long numbers (having at least NUM_OF_DIGITS digits)

  public static void problem13() {
    final int NUM_OF_DIGITS = 10;
    final String[] numbers = {
      "37107287533902102798797998220837590246510135740250",
      "46376937677490009712648124896970078050417018260538",
      "74324986199524741059474233309513058123726617309629",
      "91942213363574161572522430563301811072406154908250",
      "23067588207539346171171980310421047513778063246676",
      "89261670696623633820136378418383684178734361726757",
      "28112879812849979408065481931592621691275889832738",
      "44274228917432520321923589422876796487670272189318",
      "47451445736001306439091167216856844588711603153276",
      "70386486105843025439939619828917593665686757934951",
      "62176457141856560629502157223196586755079324193331",
      "64906352462741904929101432445813822663347944758178",
      "92575867718337217661963751590579239728245598838407",
      "58203565325359399008402633568948830189458628227828",
      "80181199384826282014278194139940567587151170094390",
      "35398664372827112653829987240784473053190104293586",
      "86515506006295864861532075273371959191420517255829",
      "71693888707715466499115593487603532921714970056938",
      "54370070576826684624621495650076471787294438377604",
      "53282654108756828443191190634694037855217779295145",
      "36123272525000296071075082563815656710885258350721",
      "45876576172410976447339110607218265236877223636045",
      "17423706905851860660448207621209813287860733969412",
      "81142660418086830619328460811191061556940512689692",
      "51934325451728388641918047049293215058642563049483",
      "62467221648435076201727918039944693004732956340691",
      "15732444386908125794514089057706229429197107928209",
      "55037687525678773091862540744969844508330393682126",
      "18336384825330154686196124348767681297534375946515",
      "80386287592878490201521685554828717201219257766954",
      "78182833757993103614740356856449095527097864797581",
      "16726320100436897842553539920931837441497806860984",
      "48403098129077791799088218795327364475675590848030",
      "87086987551392711854517078544161852424320693150332",
      "59959406895756536782107074926966537676326235447210",
      "69793950679652694742597709739166693763042633987085",
      "41052684708299085211399427365734116182760315001271",
      "65378607361501080857009149939512557028198746004375",
      "35829035317434717326932123578154982629742552737307",
      "94953759765105305946966067683156574377167401875275",
      "88902802571733229619176668713819931811048770190271",
      "25267680276078003013678680992525463401061632866526",
      "36270218540497705585629946580636237993140746255962",
      "24074486908231174977792365466257246923322810917141",
      "91430288197103288597806669760892938638285025333403",
      "34413065578016127815921815005561868836468420090470",
      "23053081172816430487623791969842487255036638784583",
      "11487696932154902810424020138335124462181441773470",
      "63783299490636259666498587618221225225512486764533",
      "67720186971698544312419572409913959008952310058822",
      "95548255300263520781532296796249481641953868218774",
      "76085327132285723110424803456124867697064507995236",
      "37774242535411291684276865538926205024910326572967",
      "23701913275725675285653248258265463092207058596522",
      "29798860272258331913126375147341994889534765745501",
      "18495701454879288984856827726077713721403798879715",
      "38298203783031473527721580348144513491373226651381",
      "34829543829199918180278916522431027392251122869539",
      "40957953066405232632538044100059654939159879593635",
      "29746152185502371307642255121183693803580388584903",
      "41698116222072977186158236678424689157993532961922",
      "62467957194401269043877107275048102390895523597457",
      "23189706772547915061505504953922979530901129967519",
      "86188088225875314529584099251203829009407770775672",
      "11306739708304724483816533873502340845647058077308",
      "82959174767140363198008187129011875491310547126581",
      "97623331044818386269515456334926366572897563400500",
      "42846280183517070527831839425882145521227251250327",
      "55121603546981200581762165212827652751691296897789",
      "32238195734329339946437501907836945765883352399886",
      "75506164965184775180738168837861091527357929701337",
      "62177842752192623401942399639168044983993173312731",
      "32924185707147349566916674687634660915035914677504",
      "99518671430235219628894890102423325116913619626622",
      "73267460800591547471830798392868535206946944540724",
      "76841822524674417161514036427982273348055556214818",
      "97142617910342598647204516893989422179826088076852",
      "87783646182799346313767754307809363333018982642090",
      "10848802521674670883215120185883543223812876952786",
      "71329612474782464538636993009049310363619763878039",
      "62184073572399794223406235393808339651327408011116",
      "66627891981488087797941876876144230030984490851411",
      "60661826293682836764744779239180335110989069790714",
      "85786944089552990653640447425576083659976645795096",
      "66024396409905389607120198219976047599490197230297",
      "64913982680032973156037120041377903785566085089252",
      "16730939319872750275468906903707539413042652315011",
      "94809377245048795150954100921645863754710598436791",
      "78639167021187492431995700641917969777599028300699",
      "15368713711936614952811305876380278410754449733078",
      "40789923115535562561142322423255033685442488917353",
      "44889911501440648020369068063960672322193204149535",
      "41503128880339536053299340368006977710650566631954",
      "81234880673210146739058568557934581403627822703280",
      "82616570773948327592232845941706525094512325230608",
      "22918802058777319719839450180888072429661980811197",
      "77158542502016545090413245809786882778948721859617",
      "72107838435069186155435662884062257473692284509516",
      "20849603980134001723930671666823555245252804609722",
      "53503534226472524250874054075591789781264330331690"
      };
    //calculate the sum -> it is concatentation of carry and reversed result
    final ArrayList<Integer> result = new ArrayList<Integer>(0);
    int carry = 0;
    for (int i = numbers[0].length() - 1; i >= 0; i--) {
      int sum = carry;
      for (int j = 0; j < numbers.length; j++) {
        sum += digit(numbers[j].charAt(i));
      };
      result.add(sum % BASE);
      carry = sum / BASE;
    }
    //printing first NUM_OF_DIGITS digits
    String carryStr = String.valueOf(carry);
    System.out.print(carryStr);
    int indexOfLastDigitToPrint = result.size() - NUM_OF_DIGITS + 
                                  carryStr.length();
    for (int i = result.size() - 1; i >= indexOfLastDigitToPrint; i--){
      System.out.print(result.get(i));
    }
    System.out.println();
  }

  private static int digit(char c) {
    return c - '0';
  }

// Problem 14 : find the number below LIMIT producing longest Collatz sequence

  public static void problem14() {
    final int LIMIT = 1000000;
    //info about numbers that appered in sequences
    boolean[] appeared = new boolean[LIMIT - 1];
    //info about numbers for which we calculated Collatz sequences lengths
    boolean[] calculated = new boolean[LIMIT - 1];
    //Collatz sequences lengths
    int[] collatzLengths = new int[LIMIT - 1];
    //distances from first terms in sequences of numbers that only appeared
    // in the middle of sequences AND appropriate first terms - in practice,
    // we have easily accesible lengths of Collatz sequences for all the numbers
    // that appear in the middle of sequences
    int[][] distancesFromStarters = new int[LIMIT - 1][2];
    int bestStart = 1;
    int maxTerms = 1;
    for (int i = 0; i < appeared.length; i++) {
      appeared[i] = false;
      calculated[i] = false;
      collatzLengths[i] = 0;
      distancesFromStarters[i][0] = 0;
      distancesFromStarters[i][1] = 0;
    }
    for (int i = 0; i < appeared.length; i++) {
      // if number appeared in previous sequences then we skip it
      if (appeared[i])
        continue;
      long num = i + 1;
      int terms = 1;
      // checking length of Collatz sequence, remembering numbers that appear
      // and their distances to first term in sequence
      while (num > 1) {
        if (num < LIMIT) {
          if (appeared[(int) num - 1]) {
          // using previously calculated values to calculate terms
            if (calculated[(int) num - 1]) {
              terms += collatzLengths[(int) num - 1] - 1;
            }
            else {
              terms += collatzLengths[distancesFromStarters[(int) num - 1][1]] 
                       - distancesFromStarters[(int) num - 1][0];
            };
          break;
          }
          else {
          //saving distance of this term to the first term 
            appeared[(int) num - 1] = true;
            distancesFromStarters[(int) num - 1][0] = terms;
            distancesFromStarters[(int) num - 1][1] = i;
          }
        }
        terms++;
        num = (num % 2 == 0) ? (num / 2) : (3 * num + 1);
      }
      //updating number with longest Collatz sequence
      if (terms >= maxTerms) {
        maxTerms = terms;
        bestStart = i + 1;
      }
      //remembering the result
      appeared[i] = true;
      calculated[i] = true;
      collatzLengths[i] = terms;
    }
    System.out.println(bestStart);
  }

// Problem 15 : How many routs are there from top left to bottom right corner
// of a DIM x DIM grid if you can only move to the right and ?

  public static void problem15() {
    final int DIM = 20;
    //table with results for subgrids
    long[][] results = new long[DIM + 1][DIM + 1];
    //inserting results for extreme cases
    for (int i = 0; i < DIM + 1; i++) {
      results[i][DIM] = 1;
      results[DIM][i] = 1;
    }
    //dynamically calculating results for larger grids
    for (int i = results.length - 2; i >= 0; i --) {
      for (int j = results[0].length - 2; j >= 0; j --) {
        results[i][j] = results[i + 1][j] + results[i][j + 1];
      }
    }
    System.out.println(results[0][0]);
  }

// Problem 16 : find sum of digits of 2^POWER

  public static void problem16() {
    final int POWER = 1000;
    BigInteger n = new BigInteger("2");
    n = n.pow(POWER);
    int sum = 0;
    String number = n.toString();
    for (int i = 0; i < number.length(); i++) {
      sum += digit(number.charAt(i));
    }
    System.out.println(sum);
  }

// Problem 17 : sum letters of numbers between 1 and 1000

  public static void problem17() {
    // 1. numbers between 1 and 9 give us 36 letters
    // they appear 90 times as part of numbers and 100 times at the beginning of
    // numbers (e.g. one hundred and ten) so we get 36*190 (we do not count now
    // "one" in "one thousand")
    // 2. numbers between 10 - 19 give us 70 letters and they appear 10 times
    // so we get 70*10
    // 3. numbers 20,..,90 give us 46 letters and appear 100 times so we get
    // 46*100
    // 4. word hundred has 7 letters and appear 900 times so we get 7*900
    // 5. word and has 3 letters and appear 99 times per each hunded except the
    // first one so we get 3*9*99
    // 9. lastly, we have to add "one thousand" which has 11 letters
    System.out.println(36 * 190 + 70 * 10 + 46 * 100 + 7 * 900 + 3 * 9 * 99 + 11);
  }

// Problem 18 : Find route from top to bottom of given trinagle (moving to 
// adjacent numbers on the row below) with maximum total

  public static void problem18() {
    int[][] triangle = {
      {75},
      {95, 64},
      {17, 47, 82},
      {18, 35, 87, 10},
      {20, 4, 82, 47, 65},
      {19, 1, 23, 75, 3, 34},
      {88, 2, 77, 73, 7, 63, 67},
      {99, 65, 4, 28, 6, 16, 70, 92},
      {41, 41, 26, 56, 83, 40, 80, 70, 33},
      {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
      {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
      {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
      {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
      {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
      {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23}
    };
    //Dynamically calculate the routes with max total starting at the bottom of
    //the triangle
    for (int i = triangle.length - 2; i >= 0; i--) {
      for (int j = 0; j < triangle[i].length; j++) {
        triangle[i][j] += Math.max(triangle[i + 1][j], triangle[i + 1][j + 1]);
      }
    };
    System.out.println(triangle[0][0]);
  }

// Problem 19 : "How many Sundays fell on the first of the month during the
// twentieth century" (January 1s 1900 was a Monday)

  public static void problem19() {
    //Note down which day of the week is first day of each month except January
    //if first of January was Sunday
    int[] regularYear = {3, 3, 6, 1, 4, 6, 2, 5, 7, 3, 5};
    int[] leapYear = {3, 4, 7, 2, 5, 7, 3, 6, 1, 4, 6};
    final int LOWER_LIMIT = 1901;
    final int UPPER_LIMIT = 2000;
    // variable holding info about which day of week is first of January of 
    // investigated year (January 1s 1901 was a Tuesday)
    int firstJan = 2;
    int result = 0;
    for (int i = LOWER_LIMIT; i <= UPPER_LIMIT; i++) {
      if (firstJan == WEEK_LENGTH)
        result++;
      if (leapYear(i)) {
        for (int j = 0; j < leapYear.length; j++) {
          if ((firstJan + leapYear[j]) % WEEK_LENGTH == 0)
            result++;
        }
        firstJan = (firstJan + 1) % WEEK_LENGTH + 1;
      }
      else {
        for (int j = 0; j < regularYear.length; j++) {
          if ((firstJan + regularYear[j]) % WEEK_LENGTH == 0)
            result++;
        }
        firstJan = firstJan % WEEK_LENGTH + 1;
      }
    }
    System.out.println(result);
  }

  private static boolean leapYear(int year) {
    if (year % YEARS_BETWEEN_LEAP_YEARS != 0)
      return false;
    return !(year % CENTURY == 0  &&
             year % Math.pow(2, YEARS_BETWEEN_LEAP_YEARS) != 0);
  }

// Problem 20 : find the sum of digits of LIMIT!

  public static void problem20() {
    final int LIMIT = 100;
    BigInteger n = new BigInteger("1");
    for (int i = 2; i <= LIMIT; i++) {
      n = n.multiply(new BigInteger(Integer.toString(i)));
    }
    int sum = 0;
    String number = n.toString();
    for (int i = 0; i < number.length(); i++) {
      sum += digit(number.charAt(i));
    }
    System.out.println(sum);
  }

}