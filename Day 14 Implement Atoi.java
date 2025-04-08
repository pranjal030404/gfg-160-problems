Given a string s,the objective is to convert it into integer format without utilizing any built-in functions.Refer the below steps to know about atoi()function.

Cases for atoi()conversion:

Skip any leading whitespaces.Check for a sign(‘+’or‘-‘),default to positive if no sign is present.Read the integer by ignoring leading zeros until a non-digit character is encountered or end of the string is reached.If no digits are present,return 0. If the integer is greater than 231–1,then return 231–1 and if the integer is smaller than-231,then return-231.

class Solution {
    public int myAtoi(String s) {
        // Your code here
        int i = 0, n = s.length(); 
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        int result = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if (result > (Integer.MAX_VALUE - digit) / 10) { // <-- corrected
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return sign * result;
    }