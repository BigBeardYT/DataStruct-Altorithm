package com.yt.october;

public class addDigits_258 {
    public static void main(String[] args) {
        int num = 38;
        int res = addDigits(num);
        System.out.println(res);
    }
    public static int addDigits(int num) {

        String s = String.valueOf(num);
//        int [] nums = s.toCharArray();

        int res = 0;
        do{
            res = fun(num);
            num = res;
        }while(res > 9);

        return res;
    }
    public static int fun(int num) {
        int res = 0;
        while(num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
}
