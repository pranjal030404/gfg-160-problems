You are given an array of integers arr[]. Your task is to reverse the given array.

Note: Modify the array in place.


class Solution {
    public void reverseArray(int arr[]) {
        // code here
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            // Swap arr[i] and arr[j]
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
        
    }
}