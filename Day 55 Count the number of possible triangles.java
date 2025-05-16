// Given an integer array arr[]. Find the number of triangles that can be formed with three different array elements as lengths of three sides of the triangle. 

// A triangle with three given sides is only possible if sum of any two sides is always greater than the third side.

class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        int n = arr.length;
        Arrays.sort(arr); // Step 1: Sort the array
        int count = 0;

        for (int k = n - 1; k >= 2; k--) { // Step 2: Fix third side
            int i = 0, j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i); // Step 3: Valid triangles
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}