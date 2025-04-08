// Given an array prices[] of length n, representing the prices of the stocks on
// different days. The task is to find the maximum profit possible by buying and
// selling the stocks on different days when at most one transaction is allowed.
// Here one transaction means 1 buy + 1 Sell. If it is not possible to make a
// profit then return 0.
// Note: Stock must be bought before being sold.

class Solution {
    public int maximumProfit(int prices[]) {
        // code here
        if (prices == null || prices.length == 0)
            return 0;

        int maxProfit = 0, bestBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - bestBuy);
            bestBuy = Math.min(bestBuy, prices[i]);
        }

        return maxProfit;
    }
}