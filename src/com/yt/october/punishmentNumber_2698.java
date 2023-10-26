package com.yt.october;

public class punishmentNumber_2698 {
    public static void main(String[] args) {
        System.out.println(countDigits(1248));
    }

    public static int countDigits(int num) {
        int res = 0;
        String s = String.valueOf(num);
        for(int i = 0;i < s.length();i++) {
            int n = s.charAt(i) - '0';
            if(num % n == 0) {
                res++;
            }
        }
        return res;
    }
    public static int punishmentNumber(int n) {
        int res = 0;
        for(int i = 1;i <= n;i++) {
            int t = i * i;
            // 判断t是否满足分割之后的整数值之和为i
            if(check(i, t)) {
                res += t;
            }
        }

        return res;
    }

    public static boolean check(int target, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        if(len == 1) {
            return n == 1;
        }
        for(int i = 1;i < len;i++) {
            int prev = Integer.valueOf(s.substring(0, i));
            int rear = Integer.valueOf(s.substring(i, len));
            if(prev + rear == target) {
                return true;
            }
        }

        return false;
    }
}
