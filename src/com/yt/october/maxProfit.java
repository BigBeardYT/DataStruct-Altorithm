package com.yt.october;

public class maxProfit {
    // leetcode
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int [] dp = new int[n];
        dp[0] = 0;
        int min_price = prices[0];
        for(int i = 1;i < n;i++){
            min_price = Math.min(min_price, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - min_price);
        }
        return dp[n-1];
    }
}
