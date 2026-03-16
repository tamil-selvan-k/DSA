import java.util.*;

public class MinStepsToReachCarrot {
  static class Pair{
    int row, col, steps;
    public Pair(int row, int col, int st) {
      this.row = row;
      this.col = col;
      this.steps = st;
    }
  }

  static int[] r = {-1, 0, 1, 0};
  static int[] c = {0, 1, 0, -1};

  static boolean[][] vis;
  static Queue<Pair> q = new LinkedList<>();
  private static int bfs(char[][] mat, int row, int col, int M, int N) {
    q.add(new Pair(row, col, 0));
    vis[row][col] = true;
    while(!q.isEmpty()) {
      Pair p = q.poll();
      if(mat[p.row][p.col] == 'C') {
        return p.steps;
      }

      for(int i=0;i<4;i++) {
        int nrow = p.row + r[i];
        int ncol = p.col + c[i];

        if(nrow < M && ncol < N && nrow >= 0 && ncol >= 0 && mat[nrow][ncol] != 'B' && !vis[nrow][ncol]) {
          q.add(new Pair(nrow, ncol, p.steps + 1));
          vis[nrow][ncol] = true;
        }
      }

      
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner get = new Scanner(System.in);
    int M = get.nextInt();
    int N = get.nextInt();

    char[][] mat = new char[M][N];
    vis = new boolean[M][N];
    get.nextLine();
    for(int i=0;i<M;i++) {
      for(int j=0;j<N;j++) {
        mat[i][j] = get.next().charAt(0);
      }
      get.nextLine();
    }
    int i = get.nextInt();
    int j = get.nextInt();

    System.out.println(bfs(mat, i, j, M, N)); 
  }
}

