//You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.



class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int r = mat.length;
        int c = mat[0].length;
        
        int top = 0, bottom = r - 1;
        int left = 0, right = c - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from Left to Right
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;
            
            // Traverse from Top to Bottom
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;
            
            // Traverse from Right to Left
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from Bottom to Top
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}