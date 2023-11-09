package com.yt.november;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class maximumMinutes_2258 {
    public static int INF = (int) 1e9;
    public static int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public static void main(String[] args) {
        maximumMinutes(new int[][]{
                {0,2,0,0,0,0,0},
                {0,0,0,2,2,1,0},
                {0,2,0,0,1,2,0},
                {0,0,2,2,2,0,2},
                {0,0,0,0,0,0,0},
        });
    }


    public static int maximumMinutes(int[][] grid) {
        // 1: 着火的格子， 2：墙
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        // 从火的角度出发，先计算出每个格子会着火的时间
        int [][] fireTimes = new int[m][n];
        for(int i = 0;i < m;i++) {
            Arrays.fill(fireTimes[i], INF);
        }
        // 通过广度优先求出每个格子最早的着火时间
        bfs(grid, fireTimes);

        for(int [] fireTime : fireTimes) {
            System.out.println(Arrays.toString(fireTime));
        }
        // 二分查找找到最长的停留时间
        res = -1;
        int low = 0, high = m * n;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(!check(fireTimes, grid, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res >= m * n ? INF : res;
    }

    private static boolean check(int[][] fireTimes, int[][] grid, int stayTime) {
        // 判断在经过mid时间的停留后，是否可以到达指定地点
        if(stayTime == fireTimes[0][0]) {
            return false;
        }
        int m = grid.length, n = grid[0].length;
        boolean [][] visit = new boolean[m][n];
        Queue<int []> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0, stayTime});
        visit[0][0] = true;

        while(!queue.isEmpty()) {
            int [] arr = queue.poll();
            // 行、列以及时间
            int row = arr[0], col = arr[1], time = arr[2];
            for(int i = 0;i < 4;i++) {
                int new_row = row + dirs[i][0];
                int new_col = col + dirs[i][1];
                if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n) {
                    // 判断到的这个格子是否为墙
                    if(grid[new_row][new_col] == 2) {
                        continue;
                    }
                    // 判断是否到达安全屋
                    if(new_row == m-1 && new_col == n-1) {
                        return fireTimes[new_row][new_col] >= time + 1;
                    }
                    // 还未碰到蔓延过来的火，装入队列
                    if(fireTimes[new_row][new_col] > time + 1) {
                        queue.offer(new int[]{new_row, new_col, time+1});
                        visit[new_row][new_col] = true;
                    }

                }
            }
        }

        return false;
    }

    private static void bfs(int[][] grid, int[][] fireTimes) {
        int m = grid.length;
        int n = grid[0].length;
        // 定义一个队列, 初始化
        Queue<int []> queue = new ArrayDeque<int []>();
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    fireTimes[i][j] = 0;
                }
            }
        }

        int time = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 便利队列中的每一个元素
            for(int i = 0;i < size;i++) {
                int [] arr = queue.poll();
                int row = arr[0], col = arr[1];
                for(int j = 0;j < 4;j++) {
                    int new_row = row + dirs[j][0];
                    int new_col = col + dirs[j][1];
                    if(new_row >= 0 && new_row < m && new_col >= 0 && new_col < n) {
                        // 判断蔓延到的这个格子是否为墙或已经是火
                        if(grid[new_row][new_col] == 2 || fireTimes[new_row][new_col] != INF) {
                            continue;
                        }

                        // 装入队列
                        queue.offer(new int[]{new_row, new_col});

                        fireTimes[new_row][new_col] = Math.min(fireTimes[new_row][new_col], time);

                    }
                }
            }
            time++;
        }

    }

    public static void getFireTimes(int[][] grid, int [][] fireTimes, int row, int col, int time) {
        if(row < 0 || col > grid[0].length - 1 || grid[row][col] == 2) {
            return ;
        }
        time++;
        // 火向四周蔓延 (up, col), (down, col), (row, left), (row, right) 上下左右
        int up = row - 1, down = row + 1, left = col - 1, right = col + 1;
        // 判断索引的合法性,并且此处不是墙，就标记为着火
        if(up >= 0 && grid[up][col] != 2) {
            fireTimes[up][col] = Math.min(fireTimes[up][col], time);

        }
        if(down <= grid.length && grid[down][col] != 2) {
            fireTimes[down][col] = Math.min(fireTimes[down][col], time);

        }
        if(left >= 0 && grid[row][left] != 2) {
            fireTimes[row][left] = Math.min(fireTimes[row][left], time);
        }
        if(right < grid[0].length && grid[row][right] != 2) {
            fireTimes[row][right] = Math.min(fireTimes[row][right], time);
        }

        getFireTimes(grid, fireTimes, up, col, time);
        getFireTimes(grid, fireTimes, down, col, time);
//
        getFireTimes(grid, fireTimes, row, left, time);
        getFireTimes(grid, fireTimes, row, right, time);
//        time--;

    }
    public static void getFireTimes2(int[][] grid, int [][] fireTimes, int row, int col, int time) {
        if(row < 0 || col > grid[0].length - 1 || grid[row][col] == 2) {
            return ;
        }
        time++;
        fireTimes[row][col] = Math.min(fireTimes[row][col], time);
        getFireTimes2(grid, fireTimes, --row, col, time);
//        getFireTimes2(grid, fireTimes, ++row, col, time);
////
//        getFireTimes2(grid, fireTimes, row, --col, time);
//        getFireTimes2(grid, fireTimes, row, ++col, time);
//        time--;

    }
}
