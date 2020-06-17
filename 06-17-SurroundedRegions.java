class Solution {
    char board[][];
    int row, col;

    public void solve(char[][] board) {
        row = board.length;
        if (row == 0) return;
        col = board[0].length;
        this.board = board;

        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') dfs(i, 0, '@');
            if (board[i][col - 1] == 'O') dfs(i, col - 1, '@');
        }

        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O') dfs(0, j, '@');
            if (board[row - 1][j] == 'O') dfs(row - 1, j, '@');
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '@') board[i][j] = 'O';
            }
        }

    }

    public void dfs(int i, int j, char c) {
        if (board[i][j] == 'O') {
            board[i][j] = c;
            if (i < row - 1) dfs(i + 1, j, c);
            if (i > 0) dfs(i - 1, j, c);
            if (j < col - 1) dfs(i, j + 1, c);
            if (j > 0) dfs(i, j - 1, c);
        }

    }
}