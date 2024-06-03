package org.lql.hot100.dynamicProgramming;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 11:26
 * @description: 70. 爬楼梯 <a href="https://leetcode.cn/problems/climbing-stairs/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class ClimbStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        System.out.println(climbStairs.climbStairs(2));
        System.out.println(climbStairs.climbStairs(3));
    }
}
