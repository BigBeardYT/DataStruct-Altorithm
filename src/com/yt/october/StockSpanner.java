package com.yt.october;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class StockSpanner {
    public static void main(String[] args) {

    }
    Deque<int []> stack;
    int index;
    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
    }

    public int next(int price) {
        index++;
        while(true) {
            assert stack.peek() != null;
            if (!(price >= stack.peek()[1])) break;
            stack.pop();
        }
        int res = index - stack.peek()[0];
        stack.push(new int[]{index, price});
        return res;

    }
}
