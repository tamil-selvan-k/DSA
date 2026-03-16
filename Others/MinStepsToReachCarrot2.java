import java.util.*;

public class MinStepsToReachCarrot2 {
  static class Pair{
    int row, col;
    public Pair(int row, int col) {
      this.row = row;
      this.col = col;
    }
  }

  static int[] r = {-1, 0, 1, 0};
  static int[] c = {0, 1, 0, -1};

  static boolean[][] vis;
  static Queue<Pair> q = new LinkedList<>();
  private static int bfs(char[][] mat, int row, int col, int M, int N) {
    q.add(new Pair(row, col));
    vis[row][col] = true;
    int steps = -1;
    while(!q.isEmpty()) {
      Queue<Pair> temp = new LinkedList<>();
      while(!q.isEmpty()) {
        temp.add(q.poll());
      }
      steps++;

      while(!temp.isEmpty()) {
        Pair p = temp.poll();

        if(mat[p.row][p.col] == 'C') {
          return steps;
        }

        for(int i=0;i<4;i++) {
          int nrow = p.row + r[i];
          int ncol = p.col + c[i];

          if(nrow < M && ncol < N && nrow >= 0 && ncol >= 0 && mat[nrow][ncol] != 'B' && !vis[nrow][ncol]) {
            q.add(new Pair(nrow, ncol));
            vis[nrow][ncol] = true;
          }
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

