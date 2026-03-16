import java.util.*;

public class WhichRabbitWillTakeCarrotFirst {
  static class Pair{
    int row, col, steps; char rab;
    public Pair(int row, int col, char rab, int steps) {
      this.row = row;
      this.col = col;
      this.rab = rab;
      this.steps = steps;
    }
  }

  static int[] r = {-1, 0, 1, 0};
  static int[] c = {0, 1, 0, -1};

  static boolean[][] vis1, vis2;
  static Queue<Pair> q = new LinkedList<>();
  private static char bfs(char[][] mat, int row1, int col1, char r1, char r2, int row2, int col2, int M, int N) {
    q.add(new Pair(row1, col1, r1, 0));
    vis1[row1][col1] = true;
    q.add(new Pair(row2, col2, r2, 0));
    vis2[row2][col2] = true;

    while(!q.isEmpty()) {
        Pair p = q.poll();

        if(mat[p.row][p.col] == 'C') {
          return p.rab;
        }

        for(int i=0;i<4;i++) {
          int nrow = p.row + r[i];
          int ncol = p.col + c[i];

          if(nrow < M && ncol < N && nrow >= 0 && ncol >= 0 && mat[nrow][ncol] != 'B' && mat[nrow][ncol] != 'X' && mat[nrow][ncol] != 'Y') {
            if(!vis1[nrow][ncol]) {
              q.add(new Pair(nrow, ncol, p.rab, p.steps + 1));
              vis1[nrow][ncol] = true;
            } else if(!vis2[nrow][ncol]) {
              q.add(new Pair(nrow, ncol, p.rab, p.steps + 1));
              vis2[nrow][ncol] = true;
            }
            
          }
        }
      }
    return '!';
  }

  public static void main(String[] args) {
    Scanner get = new Scanner(System.in);
    int M = get.nextInt();
    int N = get.nextInt();

    char[][] mat = new char[M][N];
    vis1 = new boolean[M][N];
    vis2 = new boolean[M][N];

    get.nextLine();
    for(int i=0;i<M;i++) {
      for(int j=0;j<N;j++) {
        mat[i][j] = get.next().charAt(0);
      }
      get.nextLine();
    }
    int i = get.nextInt();
    int j = get.nextInt();
    int k = get.nextInt();
    int l = get.nextInt();

    System.out.println(bfs(mat, i, j, 'X', 'Y', k, l, M, N)); 
  }
}

