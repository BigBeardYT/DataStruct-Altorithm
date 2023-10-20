package com.yt.october;

import java.util.*;

public class tupleSameProduct_1726 {
    public static void main(String[] args) {
        System.out.println(tupleSameProduct(new int[]{2,4,5,10}));
    }

    public static int tupleSameProduct(int[] nums) {
        // 模拟，找出每一个4个元素的元组，
        int n = nums.length;
        int res = 0;
        boolean [] visited = new boolean[n];
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int depth = 0;

        dfs(nums, visited, n, 0, lists, list);

        Map<int[], Integer> map = new HashMap<>();

        for(List<Integer> ls : lists) {
            int [] arr = {ls.get(0), ls.get(1), ls.get(2), ls.get(3)};
            Arrays.sort(arr);
            map.put(arr, 1);
            System.out.println(Arrays.toString(arr));
        }
        for(List<Integer> ls : lists) {
            int a = ls.get(0), b = ls.get(1), c = ls.get(2), d = ls.get(3);
            int[] arr = {a, b, c, d};
            Arrays.sort(arr);
            if((arr[0] != arr[1] && arr[0] != arr[2] && arr[2] != arr[3] && arr[1] != arr[2] && arr[2] != arr[3]) &&
                    (arr[0] * arr[1] == arr[2] * arr[3] || arr[0] * arr[2] == arr[1] * arr[3] || arr[0] * arr[3] == arr[1] * arr[2])) {
                map.put(arr, 1);
            }
        }



        return map.size();

    }

    public static void dfs(int [] nums, boolean[] visited, int n, int depth, List<List<Integer>> lists, List<Integer> list) {
        if(depth == 4) {
            lists.add(new ArrayList<>(list));
            return ;

        }

        for(int i = 0;i < n;i++) {
            // 没被访问过
            if(!visited[i] && list.size() < 4) {
                list.add(nums[i]);
                visited[i] = true;
                depth++;
                dfs(nums, visited, n, depth, lists, list);
                depth--;
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }

    }
}
