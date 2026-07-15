class Solution {
    int M, N;
    int[] dir = {-1, 0, 1, 0, -1};
    Queue<int[]> q = new LinkedList<>();
    
    private void bfs(int[][] grid, boolean[][] vis) {
        while(!q.isEmpty()) {
            int[] t = q.poll();
            grid[t[0]][t[1]] = t[2];

            for(int i = 0; i < 4; i++) {
                int nrow = t[0] + dir[i];
                int ncol = t[1] + dir[i + 1];

                if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && !vis[nrow][ncol] && grid[nrow][ncol] != -1) {
                    q.add(new int[]{ nrow, ncol, t[2] + 1 });
                    vis[nrow][ncol] = true;
                }
            }
        }

    }
    
    public void islandsAndTreasure(int[][] grid) {
        this.M = grid.length;
        this.N = grid[0].length;

        boolean[][] vis = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 0 && !vis[i][j])  {
                    vis[i][j] = true;
                    q.add(new int[]{ i, j, 0 });
                }
            }
        }
        
        bfs(grid, vis);
        
    }
}
