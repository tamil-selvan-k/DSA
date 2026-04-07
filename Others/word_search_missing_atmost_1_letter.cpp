#include <iostream>
#include <vector>
using namespace std;

bool dfs(vector<vector<char>>& grid, int row, int col, string word, int idx, int missed) {
    if(idx == word.length() - 1) return true;
    else if(idx == word.length() - 2 && missed == 0) return true;
    char ch = grid[row][col];
    grid[row][col] = '.';

    int m = grid.size(), n = grid[0].size();

    for(int r=-1;r<=1;r++) {
        for(int c=-1;c<=1;c++) {
            int nrow = row + r;
            int ncol = col + c;

            if(nrow < m && nrow >= 0 && ncol < n && ncol >= 0 && grid[nrow][ncol] != '.') {
                if(grid[nrow][ncol] == word[idx + 1]) {
                    if(dfs(grid, nrow, ncol, word, idx + 1, missed)) 
                        return true;
                } else if(missed == 0) {
                    if(dfs(grid, nrow, ncol, word, idx + 1, missed + 1)) 
                        return true;
                }
            }
        }
    }

    grid[row][col] = ch;
    return false;
}

int main() {
  int m,n;
  cin >> m>> n;
  vector<vector<char>> grid(m, vector<char>(n));
  for (int i = 0; i < m; i++) {
    for (int j = 0; j < n; j++) {
      cin >> grid[i][j];
    }
  }

  string word;
  cin >> word;

  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
      if(grid[i][j]==word[0]){
        if(dfs(grid,i,j,word, 0, 0)){
          cout<<"true"<<endl;
          return 0;
        }
      } else if(grid[i][j] == word[1]) {
        if(dfs(grid,i,j,word, 1, 1)){
          cout<<"true"<<endl;
          return 0;
        }
      }
    }
  }

  cout << false <<endl;
}
