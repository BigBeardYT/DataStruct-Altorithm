package com.yt.november;

public class minPathCost_2304
{
    public static void main(String[] args) {
        int [][] grid = new int[][]{{5,1,2}, {4,0,3}};
        int [][] moveCost = new int[][]{{12,10,15}, {20,23,8}, {21,7,1}, {8,1,13}, {9,10,25}, {5,3,2}};

        System.out.println(minPathCost(grid, moveCost));

    }

    public static int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];
        dp[m-1] = grid[m-1];
        for(int i = m - 2;i >= 0;i--) {
            // 求出每个grid[i-1][0 - n] 到 grid[i][0] 的每条路径
            for(int j = 0;j < n;j++) {

                dp[i][j] = Integer.MAX_VALUE;

                for(int k = 0;k < n;k++) {

                    dp[i][j] = Math.min(dp[i][j], dp[i+1][k] + moveCost[grid[i][j]][k]);


                }
                dp[i][j] += grid[i][j];
            }

        }

        int res = dp[0][0];

        for(int i = 1;i < n;i++) {
            res = Math.min(res, dp[0][i]);

        }
        return res;

    }

    public static int dfs(int i, int j, int [][] grid, int [][] moveCost) {
        if(i == grid.length - 1) {
            return grid[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k = 0;k < grid[0].length;k++) {
            res = Math.min(res, dfs(i + 1, k, grid, moveCost));
        }
        return res + grid[i][j];
    }
}
