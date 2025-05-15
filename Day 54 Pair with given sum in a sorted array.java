// You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
// Note: pairs should have elements of distinct indexes



class Solution {
    int countPairs(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                if (arr[left] == arr[right]) {
                    int n = right - left + 1;
                    count += (n * (n - 1)) / 2; 
                    break; 
                }

                int leftCount = 1, rightCount = 1;

                while (left + 1 < right && arr[left] == arr[left + 1]) {
                    leftCount++;
                    left++;
                }

                while (right - 1 > left && arr[right] == arr[right - 1]) {
                    rightCount++;
                    right--;
                }

                count += leftCount * rightCount;
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
    }
}