import java.util.*;

class Solution {
    private List<List<String>> result;
    private boolean[] cols;
    private boolean[] diag1; 
    private boolean[] diag2; 
    private char[][] board;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        cols = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];
        board = new char[n][n];

        for (char[] row : board)
            Arrays.fill(row, '.');

        backtrack(0, n);
        return result;
    }

    private void backtrack(int row, int n) {
        if (row == n) {
            result.add(constructBoard());
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2])
                continue;

            cols[col] = diag1[d1] = diag2[d2] = true;
            board[row][col] = 'Q';

            backtrack(row + 1, n);

            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }

    private List<String> constructBoard() {
        List<String> res = new ArrayList<>();
        for (char[] row : board)
            res.add(new String(row));
        return res;
    }
}
