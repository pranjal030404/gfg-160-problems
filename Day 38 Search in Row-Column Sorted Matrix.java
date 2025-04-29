//Given a 2D integer matrix mat[][] of size n x m, where every row and column is sorted in increasing order and a number x, the task is to find whether element x is present in the matrix.

class Solution {
    public static boolean matSearch(int[][] mat, int x) {
        int rows = mat.length;
        if (rows == 0)
            return false;
        int cols = mat[0].length;

        int i = 0, j = cols - 1;

        while (i < rows && j >= 0) {
            if (mat[i][j] == x) {
                return true;
            } else if (mat[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}