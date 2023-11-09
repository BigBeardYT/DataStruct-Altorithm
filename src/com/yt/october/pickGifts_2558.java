package com.yt.october;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class pickGifts_2558 {
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25, 64, 12, 4, 100}, 4));
    }
    public static long pickGifts(int[] gifts, int k) {
        int n = gifts.length;
        long res = 0;
        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);

        for(int gift : gifts) {
            queue.offer(gift);
        }

        System.out.println(queue.toString());

        // 每一秒都取最大的那一堆
        while(k != 0) {
            int temp = queue.poll();
            queue.offer((int) Math.sqrt(temp));
            k--;
        }

        for(int q : queue) {
            res += q;
        }
        return res;
    }

}
