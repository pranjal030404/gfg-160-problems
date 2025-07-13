// Given a string s, count all palindromic sub-strings present in the string.
// The length of the palindromic sub-string must be greater than or equal to 2.

class Solution {
  public int countPS(String s) {
    int n = s.length();
    int count = 0;

    for (int center = 0; center < n; center++) {
      count += expandAroundCenter(s, center, center);
      count += expandAroundCenter(s, center, center + 1);
    }

    return count;
  }

  private int expandAroundCenter(String s, int left, int right) {
    int cnt = 0;
    while (left >= 0 && right < s.length() &&
           s.charAt(left) == s.charAt(right)) {
      if (right - left + 1 >= 2)
        cnt++;
      left--;
      right++;
    }
    return cnt;
  }
}