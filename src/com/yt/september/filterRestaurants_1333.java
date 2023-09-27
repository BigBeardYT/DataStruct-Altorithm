package com.yt.september;

import java.util.*;

public class filterRestaurants_1333 {
    public static void main(String[] args) {
        System.out.println(filterRestaurants(new int[][]{{1,4,1,40,10}, {2,8,0,50,5}, {3,8,1,30,4}, {4,10,0,10,3},
                {5,1,1,15,1}, {7,1,1,15,1}}, 1, 50, 10));
    }
    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        int [][] arr = new int[n][2];
        if(veganFriendly == 0) {
            // restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]
            for(int i = 0;i < n;i++) {
                // 还要考虑最大加个和距离
                if(restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                    arr[i][0] = restaurants[i][0];
                    arr[i][1] = restaurants[i][1];
                }
            }
        } else {
            for(int i = 0;i < n;i++) {
                if(restaurants[i][2] == 1 && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance) {
                    arr[i][0] = restaurants[i][0];
                    arr[i][1] = restaurants[i][1];
                }

            }
        }
        // 对arr排序，按照第二个元素的值从大到小排序，如果相同，则按照第一个元素的值排序
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    // 按照第一个元素升序排序
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });

        List<Integer> res = new ArrayList<>();
        for(int[] a : arr) {
            if(a[0] != 0) {
                res.add(a[0]);
            }
        }
        return res;
    }
}
