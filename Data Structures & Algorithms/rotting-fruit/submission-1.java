class Solution {
    // private void 
    public int orangesRotting(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int minTime = 0;
        int[] dir = { -1, 0, 1, 0, -1 };

        boolean[][] vis = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!vis[i][j] && grid[i][j] == 2) {
                    q.add(new int[]{ i, j, 0 });
                    vis[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] t = q.poll();
            int r = t[0], c = t[1], time = t[2];
            minTime = Math.max(minTime, time);

            for(int i = 0; i < 4; i++) {
                int nrow = r + dir[i];
                int ncol = c + dir[i + 1];

                if(nrow < M && ncol < N && nrow >= 0 && ncol >= 0 && grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                    q.add(new int[]{ nrow, ncol, time + 1 });
                    vis[nrow][ncol] = true;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minTime;
    }
}
