package com.yt.october;

import java.util.Arrays;
import java.util.Comparator;

public class maxSatisfaction_1402 {
    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1,-8,0,5,-7}));
    }

    public static int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);

        int n = satisfaction.length;
        for(int i = 0, j = n-1;i < j;i++, j--) {
            int temp = satisfaction[i];
            satisfaction[i] = satisfaction[j];
            satisfaction[j] = temp;
        }
        int [] dp = new int[n+1];
        dp[0] = 0;
        // dp[0] = satisfaction[0] * 1;;
        for(int i = 1;i <= n;i++) {
            dp[i] = dp[i-1] + satisfaction[i-1] * i;
        }
        int maxRes = 0;
        for(int d : dp) {
            maxRes = Math.max(maxRes, d);
        }
        return maxRes;
    }
}
