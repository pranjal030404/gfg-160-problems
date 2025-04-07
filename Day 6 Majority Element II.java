// You are given an array of integer arr[] where each number represents a vote to a candidate. Return the candidates that have votes greater than one-third of the total votes, If there's not a majority vote, return an empty array. 

class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] arr) {
        // Your code goes here.
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        if (n == 0)
            return res;
        if (n == 1) {
            res.add(arr[0]);
            return res;
        }
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        int fc = 0, sc = 0;
        for (int num : arr) {
            if (num == first) {
                fc++;
            } else if (num == second) {
                sc++;
            } else if (fc == 0) {
                first = num;
                fc = 1;
            } else if (sc == 0) {
                second = num;
                sc = 1;
            } else {
                fc--;
                sc--;
            }
        }
        fc = 0;
        sc = 0;
        for (int num : arr) {
            if (num == first)
                fc++;
            else if (num == second)
                sc++;
        }
        if (fc > n / 3)
            res.add(first);
        if (sc > n / 3 && first != second)
            res.add(second);
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = { 2, 1, 6, 6, 6, 6, 6, 5, 5, 5, 5 };
        System.out.println(sol.findMajority(arr));
    }
}