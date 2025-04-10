Given a string s consisting of lowercase English Letters. Return the first non-repeating character in s.
If there is no non-repeating character, return '$'.
Note: When you return '$' driver code will output -1.


class Solution {
    public char nonRepeatingChar(String s) {
        int[] vis = new int[26]; 
        Arrays.fill(vis, -1);    

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (vis[idx] == -1) {
                vis[idx] = i;    
            } else {
                vis[idx] = -2;   
            }
        }

        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (vis[i] >= 0) {
                minIndex = Math.min(minIndex, vis[i]);
            }
        }

        return (minIndex == Integer.MAX_VALUE) ? '$' : s.charAt(minIndex);
    }
}