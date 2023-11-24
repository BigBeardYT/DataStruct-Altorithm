package com.yt.november;

import java.util.*;

public class maximumSum_2342 {
    public static void main(String[] args) {
        System.out.println(maximumSum(new int[]{18,43,36,13,7}));
    }
    public static int maximumSum(int[] nums) {
        int res = 0;
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int num : nums) {
            // num的数位和
            int temp = num;
            int key = 0;
            while(temp != 0) {
                key += temp % 10;
                temp /= 10;
            }
            if(map.containsKey(key)) {
                map.get(key).add(num);
            } else {
                List<Integer> ls = new ArrayList<>();
                ls.add(num);
                map.put(key, ls);
            }
        }

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int temp_max = 0;
            if(entry.getValue().size() > 1) {
                List<Integer> list = entry.getValue();
                Collections.sort(list, Collections.reverseOrder());
                int cnt = 0;

                for(Integer i : list) {
                    if(cnt == 2) {
                        break;
                    }
                    temp_max += i;
                    cnt++;
                }
            }
            res = Math.max(res, temp_max);
        }
        return res;
    }
}
