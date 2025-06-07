// The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

// Given an integer n, find all distinct solutions to the n-queens puzzle.
// You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
// For eg. below figure represents a chessboard [3 1 4 2].

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int[] board = new int[n]; // board[i] = row index of queen in i-th column
        solve(0, board, res, n);
        return res;
    }

    private void solve(int col, int[] board, ArrayList<ArrayList<Integer>> res, int n) {
        if (col == n) {
            ArrayList<Integer> config = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                config.add(board[i] + 1); // +1 to match 1-based row index as per GFG
            }
            res.add(config);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(col, row, board)) {
                board[col] = row;
                solve(col + 1, board, res, n);
            }
        }
    }

    private boolean isSafe(int col, int row, int[] board) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }
}