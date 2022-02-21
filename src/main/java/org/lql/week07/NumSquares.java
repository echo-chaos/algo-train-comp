package org.lql.week07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/20 9:59 PM
 * @description: 279. 完全平方数 https://leetcode-cn.com/problems/perfect-squares/
 */
public class NumSquares {

    /**
     * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
     * <p>
     * 完全平方数 是一个整数，其值等于另一个整数的平方；
     * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
     * <p>
     * 1 <= n <= 104
     */
    private static final Logger logger = LoggerFactory.getLogger(NumSquares.class);

    /**
     * dp -> [1,2,3,4,...,n]
     *
     * dp[i] -> 1 ~ (j*j <= i)
     *
     * dp[i] -> dp[i - j * j] + 1
     *
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 最坏为i个1相加组成
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumSquares numSquares = new NumSquares();
        int i = numSquares.numSquares(12);
        System.out.println(i);
    }
}
