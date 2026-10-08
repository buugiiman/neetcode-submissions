class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;

        int l = 0;
        int r = 1;

        while (r < prices.length) {
            if (prices[l] <= prices[r]) {
                profit = Math.max(profit, prices[r] - prices[l]);
                r += 1;
            } else {
                l = r;
            }
        }

        return profit;
    }
}
