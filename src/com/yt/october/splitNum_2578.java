package com.yt.october;

import java.util.Arrays;

public class splitNum_2578 {
    public static void main(String[] args) {
        System.out.println(splitNum(4325));
    }
    public static int splitNum(int num) {
        // 最小的一个数，和第二小的数作为开头43259
        String s = String.valueOf(num);
        int res = 0;
        int n = s.length();
        int [] arr = new int[n];
        for(int i = 0;i < n;i++){
            arr[i] = Integer.valueOf(s.substring(i, i+1));
        }
        Arrays.sort(arr);
        int start_1 = 0;
        int start_2 = 0;
        for(int i = 0;i < n;i++) {
            if(i % 2 == 0) {
                start_1 = start_1 * 10 + arr[i];
            }else {
                start_2 = start_2 * 10 + arr[i];
            }


        }
        res = start_1 + start_2;


        return res;

    }
}
