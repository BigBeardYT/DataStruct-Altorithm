package com.yt.october;

public class MaxProfit_2 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        // 动态规划
        // notHaveProfit表示该天不持有股票的最大利润
        // max_profit表示该天持有股票的最大利润
        int notHaveProfit = 0;
        int max_profit = -prices[0];
        int result = 0;
        for(int i = 1;i < n;i++) {
            // 如果当前不持有，那么就一直不持有，或者将之前的卖掉，看两者谁更大
            notHaveProfit = Math.max(notHaveProfit, max_profit + prices[i]);
            // 当前持有也是两种状态而来，要么是延续之前乜有的时候的利润，要么是买入
            max_profit = Math.max(max_profit, notHaveProfit - prices[i]);

        }
        return notHaveProfit;
    }
}
