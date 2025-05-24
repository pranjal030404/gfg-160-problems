// Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.




class Solution {
    int maxLen(int[] arr) {
        // Convert 0s to -1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }
        
        HashMap<Integer, Integer> sumIndices = new HashMap<>();
        sumIndices.put(0, -1); // Initialize with sum 0 at index -1
        int prefixSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            if (sumIndices.containsKey(prefixSum)) {
                int length = i - sumIndices.get(prefixSum);
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                sumIndices.put(prefixSum, i);
            }
        }
        
        return maxLength;
    }
}