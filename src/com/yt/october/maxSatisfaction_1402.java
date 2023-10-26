package com.yt.october;

import java.util.Arrays;
import java.util.Comparator;

public class maxSatisfaction_1402 {
    public static void main(String[] args) {
        System.out.println(maxSatisfaction(new int[]{-1,-8,0,5,-7}));
    }

    public static int maxSatisfaction(int[] satisfaction) {

        Arrays.sort(satisfaction);
        int res = 0;
        int n = satisfaction.length;
        // 枚举做菜的道数
        for(int i = 1;i <= n;i++) {
            int temp = 0;
            // 做i道菜，那么要选择最大的i道菜，也就是排序后的后i道
            for(int j = 1;j <= i;j++) {
                temp += (i-j+1) * satisfaction[n-j];
            }
            res = Math.max(temp, res);
        }
        return res;
    }
}
