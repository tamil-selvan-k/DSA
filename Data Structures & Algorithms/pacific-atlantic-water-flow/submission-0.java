class Solution {
    int M, N;
    int[] dir = { -1, 0, 1, 0, -1 };
    Set<List<Integer>> pac = new HashSet<>();
    Set<List<Integer>> atl = new HashSet<>();
    boolean[][] vis1; boolean[][] vis2;

    private void checkWaterFlow(int[][] heights, int row, int col, boolean isPacific) {
        if(isPacific) {
            vis1[row][col] = true;
            pac.add(Arrays.asList(row, col ));
        } else {
            vis2[row][col] = true;
            atl.add(Arrays.asList(row, col ));
        }

        for(int i = 0; i < 4; i++) {
            int nrow = row + dir[i];
            int ncol = col + dir[i + 1];

            if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && heights[row][col] <= heights[nrow][ncol]) { 
                if(isPacific && !vis1[nrow][ncol]) {
                    checkWaterFlow(heights, nrow, ncol, true);
                } else if(!isPacific && !vis2[nrow][ncol]) {
                    checkWaterFlow(heights, nrow, ncol, false);
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.M = heights.length;
        this.N = heights[0].length;

        vis1 = new boolean[M][N];
        vis2 = new boolean[M][N];

        for(int i = 0; i < N; i++) {
            if(!vis1[0][i])
                checkWaterFlow(heights, 0, i, true);
        }
        for(int i = 0; i < M; i++) {
            if(!vis1[i][0])
            checkWaterFlow(heights, i, 0, true);
        }

        for(int i = 0; i < M; i++) {
            if(!vis2[i][N-1])
            checkWaterFlow(heights, i, N - 1, false);
        }
        
        for(int i = 0; i < N-1; i++) {
            if(!vis2[M-1][i])
            checkWaterFlow(heights, M - 1, i, false);
        }

        pac.retainAll(atl);

        return new ArrayList<>(pac);
    }
}
