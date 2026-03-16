class Pair {
    public:
    int row, col, steps;
    Pair(int row, int col, int steps) {
        this->row = row;
        this->col = col;
        this->steps = steps;
    }
};

class Solution {
    int M, N;
public:
    queue<Pair> q;

    int findPath(vector<vector<int>>& grid, vector<vector<bool>>& vis) {
        q.push(Pair(0, 0, 1));
        vis[0][0] = true;

        while(!q.empty()) {
            Pair p = q.front();
            q.pop();
            if(p.row == M - 1 && p.col == N - 1) return p.steps;

            for(int dr=-1;dr<=1;dr++) {
                for(int dc=-1;dc<=1;dc++) {
                    if(dr == 0 && dc == 0) continue;

                    int nrow = p.row + dr;
                    int ncol = p.col + dc;

                    if(nrow < M && nrow >= 0 && ncol < N && ncol >= 0 && !vis[nrow][ncol] && grid[nrow][ncol] != 1) {
                        q.push(Pair(nrow, ncol, p.steps+1));
                        vis[nrow][ncol] = true;
                    }

                }
            }
        }

        return -1;
    }

    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        this->M = grid.size();
        this->N = grid[0].size();
        vector<vector<bool>> vis(M, vector<bool> (N, false));
        if(grid[0][0] == 1) return -1;

        return findPath(grid, vis);

    }
};
