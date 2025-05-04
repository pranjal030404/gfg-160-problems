//Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.



class Solution {
    public int countPairs(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;
            if (map.containsKey(complement)) {
                count += map.get(complement);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }
}