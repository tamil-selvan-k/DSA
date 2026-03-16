import java.util.*;

public class Solution {
  private static final int K = 67;
  public static void exec(Scanner get) {
    int n = get.nextInt();
    int[] arr = new int[n];
    for(int i=0;i<n;i++){
      arr[i] = get.nextInt();
    }

    int pro = 1;
    int j = 0;

    boolean isPresent = false;

    for(int i=0;i<n;i++ ) {
      pro *= arr[i];
      if(pro == K) {
        isPresent = true;
      }
      while(j <= i && pro > K) {
        pro /= arr[j++];
      }
      if(pro == 0) pro = 1;
      else if(pro == K) {
        isPresent = true;
      }
    }

    for(int i=n-1;i>=0;i--) {
      pro *= arr[i];
      if(pro == K) {
        isPresent = true;
      }
      while(j >= i && pro > K) {
        pro /= arr[j--];
      }
      if(pro == 0) pro = 1;
      else if(pro == K) {
        isPresent = true;
      }
    }

    if(isPresent) System.out.println("YES");
    else
    System.out.println("NO");
  }
  public static void main(String[] args) {
    Scanner get = new Scanner(System.in);
    int t = get.nextInt();
    while(t-- > 0) {
      exec(get);
    }
  }
}