Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, "act" and "tac" are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

Note: You can assume both the strings s1 & s2 are non-empty.


class Solution {
    public boolean areAnagrams(String s1, String s2) {
        
        if (s1.length() != s2.length()) return false;

        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }

        return true;
    }
}
