// Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

// A sudoku solution must satisfy all of the following rules:

// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.

class Solution {
    static void solveSudoku(int[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][] box = new boolean[9][10];

        // Pre-fill the constraints
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];
                if (num != 0) {
                    row[i][num] = true;
                    col[j][num] = true;
                    box[getBoxIndex(i, j)][num] = true;
                }
            }
        }

        solve(board, 0, 0, row, col, box);
    }

    static boolean solve(int[][] board, int i, int j,
            boolean[][] row, boolean[][] col, boolean[][] box) {
        if (i == 9)
            return true; // Board complete

        if (j == 9)
            return solve(board, i + 1, 0, row, col, box); // Move to next row

        if (board[i][j] != 0)
            return solve(board, i, j + 1, row, col, box); // Skip filled cells

        for (int num = 1; num <= 9; num++) {
            int bIdx = getBoxIndex(i, j);
            if (!row[i][num] && !col[j][num] && !box[bIdx][num]) {
                board[i][j] = num;
                row[i][num] = col[j][num] = box[bIdx][num] = true;

                if (solve(board, i, j + 1, row, col, box))
                    return true;

                // Backtrack
                board[i][j] = 0;
                row[i][num] = col[j][num] = box[bIdx][num] = false;
            }
        }

        return false;
    }

    static int getBoxIndex(int i, int j) {
        return (i / 3) * 3 + (j / 3);
    }
}