package com.yt.november;

public class findTheLongestBalancedSubstring2609 {

    public static void main(String[] args) {
        System.out.println(findTheLongestBalancedSubstring("010001111"));
    }
    public static int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int n = s.length();
        int i = 0;
        while(i < n) {

            int zero_cnt = 0, one_cnt = 0;
            while(i < n && s.charAt(i) == '0') {
                zero_cnt++;
                i++;
            }
            while(i < n && s.charAt(i) == '1') {
                one_cnt++;
                i++;
            }

            res = Math.max(res, Math.min(zero_cnt, one_cnt) * 2);
        }
        return 0;
    }
}
