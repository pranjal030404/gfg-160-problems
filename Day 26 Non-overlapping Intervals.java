// Given a 2D array intervals[][] of representing intervals where intervals [i] = [starti, endi ]. Return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

class Solution {
    static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 0;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= end) {
                end = interval[1];
            } else {
                count++;
            }
        }

        return count;
    }
}
