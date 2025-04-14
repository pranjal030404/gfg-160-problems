// Given an integer array citations[], where citations[i] is the number of citations a researcher received for the ith paper. The task is to find the H-index.

// H-Index is the largest value such that the researcher has at least H papers that have been cited at least H times.

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;

        for (int i = 0; i < n; i++) {
            int papersWithAtLeastThisCitation = n - i;
            if (citations[i] >= papersWithAtLeastThisCitation) {
                h = papersWithAtLeastThisCitation;
                break;
            }
        }

        return h;
    }
}