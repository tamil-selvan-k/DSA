class Solution {
    int M, N;
    boolean[][] vis;
    int[] r = {-1, 0, 1, 0};
    int[] c = {0, 1, 0, -1};

    void dfs(int row, int col, char[][] board) {
        vis[row][col] = true;

        for(int i=0;i<4;i++)  {
            int nrow = row + r[i];
            int ncol = col + c[i];

            if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && !vis[nrow][ncol] && board[nrow][ncol] != '.') {
                dfs(nrow, ncol, board);
            }
        }
    }

    public int countBattleships(char[][] board) {
        M = board.length;
        N = board[0].length;

        vis = new boolean[M][N];
        int count = 0;

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(!vis[i][j] && board[i][j] != '.') {
                    dfs(i, j, board);
                    count++;
                }
            }
        }   

        return count;
    }
}
