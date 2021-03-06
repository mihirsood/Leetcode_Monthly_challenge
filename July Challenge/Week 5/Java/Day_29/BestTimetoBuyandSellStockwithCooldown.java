// Problem :https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
// Solution:
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int len = prices.length;
        int[] sell = new int[len]; //sell[i] means must sell at day i
        int[] cooldown = new int[len]; //cooldown[i] means day i is cooldown day
        sell[1] = prices[1] - prices[0];
        for(int i = 2; i < prices.length; ++i){
            cooldown[i] = Math.max(sell[i - 1], cooldown[i - 1]);
            sell[i] = prices[i] - prices[i - 1] + Math.max(sell[i - 1], cooldown[i - 2]);
        }
        return Math.max(sell[len - 1], cooldown[len - 1]);
    }
}
