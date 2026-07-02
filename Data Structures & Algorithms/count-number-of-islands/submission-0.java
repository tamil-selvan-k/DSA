class Solution {
    int[] dir = { -1, 0, 1, 0, -1 };
    int M, N;

    private void dfs(char[][] grid, int row, int col, boolean[][] vis) {
        vis[row][col] = true;

        for(int i = 0; i < 4; i++) {
            int nrow = row + dir[i];
            int ncol = col + dir[i + 1];

            if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                dfs(grid, nrow, ncol, vis);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        M = grid.length;
        N = grid[0].length;

        boolean[][] vis = new boolean[M][N];
        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(grid[i][j] == '1' && !vis[i][j]) {
                    dfs(grid, i, j, vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
