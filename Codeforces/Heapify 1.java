import java.util.*;

public class Main {
  public static void exec(Scanner get) {
    int n = get.nextInt();
    int[] arr = new int[n+1];
    for(int i=1;i<=n;i++){
      arr[i] = get.nextInt();
    }

    boolean[] vis = new boolean[n + 1];
    boolean pos = true;

    for(int i=1;i<=n;i++) {
      if(vis[i]) continue;

      List<Integer> indices = new ArrayList<>();
      int x = i;

      while(x <= n && !vis[x]) {
        indices.add(x);
        vis[x] = true;
        x *= 2;
      }

      List<Integer> vals = new ArrayList<>();

      for(int ind:indices) {
        vals.add(arr[ind]);
      }

      Collections.sort(indices);
      Collections.sort(vals);

      int len = indices.size();
      for(int j=0;j<len;j++) {
        if(!indices.get(j).equals(vals.get(j))) {
          pos = false;
          break;
        }
      }
      if(!pos) break;
    }

    if(pos) System.out.println("Yes");
    else System.out.println("No");

  }
  public static void main(String[] args) {
    Scanner get = new Scanner(System.in);
    int t = get.nextInt();
    while(t-- > 0) {
      exec(get);
    }
  }
}