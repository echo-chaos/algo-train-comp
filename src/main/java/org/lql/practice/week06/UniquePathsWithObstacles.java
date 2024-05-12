package org.lql.practice.week06;

/**
 * @author: lql
 * @date: 2022/2/13 22:12
 * @description: 63. 不同路径 II <a href="https://leetcode-cn.com/problems/unique-paths-ii/">...</a>
 */
public class UniquePathsWithObstacles {

    /**
     * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     * m ==obstacleGrid.length
     * n ==obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     */
    private int m;
    private int n;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        return countPaths(obstacleGrid, 0, 0);
    }

    public int countPaths(int[][] obstacleGrid, int row, int col) {
        if (row < m && col < n && obstacleGrid[row][col] == 1) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        return countPaths(obstacleGrid, row + 1, col) + countPaths(obstacleGrid, row, col + 1);
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        // 初始化动态规划数组
        int[][] dp = new int[m][n];
        dp[0][0] = 1; // 如果起始点无障碍

        // 处理第一列
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                dp[i][0] = dp[i - 1][0];
            } else {
                dp[i][0] = 0; // 遇到障碍物，后续路径数也为0
            }
        }

        // 处理第一行
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0) {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = 0;
            }
        }

        // 动态规划填充剩余部分
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        // 2
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles1(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        // 1
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles1(new int[][]{{0, 1}, {0, 0}}));
    }
}
