// Given a string s, your task is to find the longest palindromic substring within s.

// A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

// A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

// Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.





class Solution {
    static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        int maxLength = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLength) {
                    start = l;
                    maxLength = r - l + 1;
                }
                l--; r++;
            }

            l = i;
            r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > maxLength) {
                    start = l;
                    maxLength = r - l + 1;
                }
                l--; r++;
            }
        }

        return s.substring(start, start + maxLength);
    }
}
