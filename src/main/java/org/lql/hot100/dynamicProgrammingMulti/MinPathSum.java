package org.lql.hot100.dynamicProgrammingMulti;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 17:19
 * @description: 64. 最小路径和 <a href="https://leetcode.cn/problems/minimum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MinPathSum {

    /**
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * <p>
     * 示例 2：
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     * <p>
     * 提示：
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 200
     * 0 <= grid[i][j] <= 200
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        // 初始化一个与网格相同大小的二维数组dp，用于存储到达每个位置的最小路径和
        int[][] dp = new int[m][n];
        // 初始化起始位置的最小路径和为网格起始位置的值
        dp[0][0] = grid[0][0];
        // 计算第一列的最小路径和，只能向下移动
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 计算第一行的最小路径和，只能向右移动
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // 计算剩余位置的最小路径和，取到达当前位置的向下和向右移动的最小路径和加上当前位置的值
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        MinPathSum minPathSum = new MinPathSum();
        // 7
        System.out.println(minPathSum.minPathSum(grid));
        // 12
        System.out.println(minPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
    }

}
