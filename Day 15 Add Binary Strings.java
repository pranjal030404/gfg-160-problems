// Given two binary strings s1 and s2 consisting of only 0s and 1s. Find the resultant string after adding the two Binary Strings.
// Note: The input strings may contain leading zeros but the output string should not have any leading zeros.

class Solution {
    public String addBinary(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) sum += s1.charAt(i--) - '0';
            if (j >= 0) sum += s2.charAt(j--) - '0';

            result.insert(0, (char) ((sum % 2) + '0'));
            carry = sum / 2;
        }

    
        int pos = 0;
        while (pos < result.length() - 1 && result.charAt(pos) == '0') {
            pos++;
        }

        return result.substring(pos);
    }
}
