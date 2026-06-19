class Solution {
    public boolean isValidSudoku(char[][] board) {
        final int N = 9;
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < N; i++) {
            for(int col = 0; col < N; col++) {
                if(set.contains(board[i][col])) {
                    return false;
                }
                if(board[i][col] != '.')
                    set.add(board[i][col]);
            }

            set.clear();

            for(int row = 0; row < N; row++) {
                if(set.contains(board[row][i])) {
                    return false;
                }
                if(board[row][i] != '.')
                set.add(board[row][i]);
            }

            set.clear();

            int row = (i / 3) * 3;
            int col = (i % 3) * 3;

            for(int r = row; r < row + 3; r++) {
                for(int c = col; c < col + 3; c++) {
                    if(set.contains(board[r][c])) {
                        return false;
                    }
                    if(board[r][c] != '.')
                        set.add(board[r][c]);
                }
            }
            set.clear();
        }

        return true;
    }
}
