class Solution {
    int M, N;

    bool dfs(int ri, int ci, vector<vector<char>>& board, string word, int ind) {
        if(ind + 1 == word.length()) return true;

        char ch = board[ri][ci];
        board[ri][ci] = '$';

        for(int i=-1;i<=1;i++) {
            for(int j=-1;j<=1;j++) {
                int nrow = ri + i;
                int ncol = ci + j;

                if(nrow < M && ncol < N && nrow >= 0 && ncol >= 0 && board[nrow][ncol] != '$' && board[nrow][ncol] == word[ind + 1]) {
                    if(dfs(nrow, ncol, board, word, ind + 1)) {
                        return true;
                    }
                }
            }
        }

        board[ri][ci] = ch;
        return false;
    }
public:
    bool exist(vector<vector<char>>& board, string word) {
        this->M = board.size();
        this->N = board[0].size();

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
                if(board[i][j] != '$' && word[0] == board[i][j]) {
                    if(dfs(i, j, board, word, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
};
