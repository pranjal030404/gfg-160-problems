// The stock span problem is a financial problem where we have a series of daily price quotes for a stock and we need to calculate the span of stock price for all days. The span arr[i] of the stocks price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the given day is less than or equal to its price on the current day.



class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                span.add(i + 1);
            } else {
                span.add(i - stack.peek());
            }
            stack.push(i);
        }
        return span;
    }
}