// Given an array arr[] and an integer target. You have to find the number of pairs in the array whose sum is strictly less than the target

class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int count = 0;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                count += (right - left);
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}