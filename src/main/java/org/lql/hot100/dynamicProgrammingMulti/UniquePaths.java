package org.lql.hot100.dynamicProgrammingMulti;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 17:13
 * @description: 62. 不同路径 <a href="https://leetcode.cn/problems/unique-paths/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class UniquePaths {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * 示例 1：
     * <p>
     * 输入：m = 3, n = 7
     * 输出：28
     * <p>
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * <p>
     * 示例 3：
     * <p>
     * 输入：m = 7, n = 3
     * 输出：28
     * 示例 4：
     * <p>
     * 输入：m = 3, n = 3
     * 输出：6
     * <p>
     * 提示：
     * <p>
     * 1 <= m, n <= 100
     * 题目数据保证答案小于等于 2 * 109
     */
    public int uniquePaths(int m, int n) {
        // 初始化动态规划数组，dp[i][j] 表示到达位置 (i, j) 的路径数量
        int[][] dp = new int[m][n];
        // 初始化第一行和第一列的路径数量为1，因为只能向下或向右移动
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        // 从第二行第二列开始，动态规划计算到达每个位置的路径数量
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 到达位置 (i, j) 的路径数量等于到达上方位置 (i-1, j) 和左方位置 (i, j-1) 的路径数量之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        // 28
        System.out.println(uniquePaths.uniquePaths(3, 7));
        // 3
        System.out.println(uniquePaths.uniquePaths(3, 2));
        // 28
        System.out.println(uniquePaths.uniquePaths(7, 3));
        // 6
        System.out.println(uniquePaths.uniquePaths(3, 3));
    }
}
