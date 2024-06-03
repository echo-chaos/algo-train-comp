package org.lql.hot100.dynamicProgramming;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 11:59
 * @description: 279. 完全平方数 <a href="https://leetcode.cn/problems/perfect-squares/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class NumSquares {

    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 12
     * 输出：3
     * 解释：12 = 4 + 4 + 4
     * <p>
     * 示例 2：
     * <p>
     * 输入：n = 13
     * 输出：2
     * 解释：13 = 4 + 9
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 104
     */
    public int numSquares(int n) {
        /*
         * dp -> [1,2,3,4,...,n]
         *
         * dp[i] -> 1 ~ (j*j <= i)
         *
         * dp[i] -> dp[i - j * j] + 1
         *
         */
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏为i个1相加组成
            dp[i] = i;
            /*
             * 遍历所有可能的完全平方数 j*j，尝试更新 dp[i]。
             * 如果 j*j 大于 i，则不需要继续遍历，因为已经无法构成更小的完全平方数了。
             */
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        System.out.println(numSquares.numSquares(12));
        System.out.println(numSquares.numSquares(13));
    }
}
