package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/8 10:09
 * @description: 70. 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/description/
 */
public class ClimbStairs {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 1 <= n <= 45
     */

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(2);
        System.out.println(i);
    }
}
