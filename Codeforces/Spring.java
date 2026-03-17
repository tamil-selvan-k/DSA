import java.util.*;

public class Spring {
  private static long gcd(long a, long b) {
    long tp = 0;
    while(b != 0) {
      tp = a % b;
      a = b;
      b = tp;
    }

    return a;
  }

  private static void exec(Scanner get) {
    long a = get.nextLong();
    long b = get.nextLong();
    long c = get.nextLong(); 
    long m = get.nextLong();

    long labc = ((a*b*c)*(gcd(a, gcd(b, c)))) / (gcd(a, b) * gcd(b, c) * gcd(a, c));
    long lab = (a*b) / gcd(a, b);
    long lbc = (b*c) / gcd(b,c);
    long lac = (a*c) / gcd(a, c);

    long triple = m / labc;
    long ab = (m/lab) - triple;
    long bc = (m/lbc) - triple;
    long ac = (m/lac) - triple;

    long aonly = (m/a) - ab - ac - triple;
    long bonly = (m/b) - ab - bc - triple;
    long conly = (m/c) - bc - ac - triple;

    long alice = (aonly * 6 )+ (ab*3) + (ac*3) + (triple*2);
    long bob = (bonly * 6) + (ab*3) + (bc*3) + (triple*2);
    long chalie = (conly * 6) + (ac * 3) + (bc * 3) + (triple * 2);
    System.out.println(alice + " " + bob + " " + chalie);
  }

  public static void main(String[] args) {
    Scanner get = new Scanner(System.in);
    int t = get.nextInt();
    while(t-- > 0) exec(get);
  }
}

