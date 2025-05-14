// Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
// Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.



class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length < 2) return result;
        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(target - sum);
            if (diff < closestDiff || 
               (diff == closestDiff && Math.abs(arr[right] - arr[left]) > maxAbsDiff)) {
                closestDiff = diff;
                maxAbsDiff = Math.abs(arr[right] - arr[left]);
                result = Arrays.asList(arr[left], arr[right]);
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}