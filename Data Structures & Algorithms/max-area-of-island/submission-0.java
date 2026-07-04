class Solution {
    int[] dir = { -1, 0, 1, 0, -1 };

    private int bfs(int[][] grid, int row, int col, boolean[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ row, col });
        vis[row][col] = true;
        int M = grid.length;
        int N = grid[0].length;
        int area = 0;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            area++;
            
            for(int i=0;i<4;i++) {
                int nrow = node[0] + dir[i];
                int ncol = node[1] + dir[i + 1];

                if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }

        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int M = grid.length;
        int N = grid[0].length;
        boolean[][] vis = new boolean[M][N];

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(!vis[i][j] && grid[i][j] == 1) {
                   maxArea = Math.max(bfs(grid, i, j, vis), maxArea);
                }
            }
        }
        return maxArea;
    }
}
