package com.yt.september;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class multiSearch_17_17 {
    public static int[][] multiSearch(String big, String[] smalls) {
        int n = smalls.length;
        int m = big.length();
        List<List<Integer>> res = new ArrayList<>();
        for(String s : smalls) {
            // 先检查是否包含
            if (big.contains(s)) {
                List<Integer> list = new ArrayList<>();
                int k = s.length();
                char c = s.charAt(0);
                for(int i = 0;i < m;i++){
                    if (big.charAt(i) == c){
                        if (i + k < n && big.substring(i, i+k).equals(s)) {
                            list.add(i);
                        }
                    }
                }
                res.add(list);
            }
        }

        int [][] ans = new int[n][m];
        int idx = 0;
        for(List<Integer> list : res){
            for(int i = 0;i < list.size();i++){
                ans[idx][i] = list.get(i);
            }
            idx++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String big = "mississippi";
        String[] smalls = new String[]{"is", "ppi","hi","sis","i","ssippi"};
        System.out.println(multiSearch(big, smalls));

    }
}
