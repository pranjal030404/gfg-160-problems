// You are given a histogram represented by an array arr, where each element of
// the array denotes the height of the bars in the histogram. All bars have the
// same width of 1 unit.

// Your task is to find the largest rectangular area possible in the given
// histogram, where the rectangle can be formed using a number of contiguous
// bars

class Solution {
  public static int getMaxArea(int[] arr) {
    int n = arr.length;
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int i = 0;
    while (i < n) {
      if (stack.isEmpty() || arr[stack.peek()] <= arr[i]) {
        stack.push(i++);
      } else {
        int height = arr[stack.pop()];
        int width = stack.isEmpty() ? i : i - stack.peek() - 1;
        maxArea = Math.max(maxArea, height * width);
      }
    }
    while (!stack.isEmpty()) {
      int height = arr[stack.pop()];
      int width = stack.isEmpty() ? i : i - stack.peek() - 1;
      maxArea = Math.max(maxArea, height * width);
    }
    return maxArea;
  }
}