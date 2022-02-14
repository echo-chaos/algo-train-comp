package org.lql.week06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/10 23:27
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
    private static final Logger logger = LoggerFactory.getLogger(ClimbStairs.class);

    /**
     *  f(n) = f(n-1) + f(n-2)
     *  [1,2,3,...n-2,n-1,n]
     *             q   p  r
     *   ->->->->->->->->->
     *  q -> p
     *  p -> r
     *  r -> p + q
     */
    public int climbStairs(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 1; i <= n; i++) {
            q = p;
            p = r;
            r = p + q;
        }
        return r;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(4);
        System.out.println(i);
    }
}
