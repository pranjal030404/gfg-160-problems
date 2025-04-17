// Given an array of Intervals arr[][], where arr[i] = [starti, endi]. The task is to merge all of the overlapping Intervals.


class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();
        
        for (int[] interval : arr) {
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } else {
                result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        return result;
    }
}