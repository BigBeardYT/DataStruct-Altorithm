package com.yt.october;

import java.util.Arrays;

public class maxKelements_2530 {
    public static void main(String[] args) {
        System.out.println(maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }

    public static long maxKelements(int[] nums, int k) {
        long res = 0;
        int n = nums.length;
        while(k-- != 0) {
            Arrays.sort(nums);
            res += nums[n-1];
            nums[n-1] = (int)Math.ceil(nums[n-1] / 3);
        }
        return res;
    }
}
