package com.yt.october;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class dailyTemperatures_739 {


    // 下一个更高温度
    public static void main(String[] args) {
        int [] tempera = new int[]{73,74,75,71,69,72,76,73};
        int [] ans = dailyTemperatures(tempera);
        System.out.println(Arrays.toString(ans));
    }
    public static int [] dailyTemperatures(int [] temperatures) {
        int n = temperatures.length;
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[n];


        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && temperatures[i] > stack.peek()[1]) {
                int j = stack.pop()[0];
                res[j] = i - j;

            }
            stack.push(new int[]{i, temperatures[i]});


        }



        return res;
    }
}
