package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/21 9:01 PM
 * @description: 518. 零钱兑换 II  https://leetcode-cn.com/problems/coin-change-2/
 */
public class CoinChangeII {

    /**
     * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
     * <p>
     * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
     * <p>
     * 假设每一种面额的硬币有无限个。
     * <p>
     * 题目数据保证结果符合 32 位带符号整数。
     * <p>
     * 1 <= coins.length <= 300
     * 1 <= coins[i] <= 5000
     * coins 中的所有值 互不相同
     * 0 <= amount <= 5000
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount+1];
        f[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                f[j] += f[j-coins[i]];
            }
        }
        return f[amount];
    }

    public static void main(String[] args) {
        CoinChangeII changeII = new CoinChangeII();
        int[] coins = {1, 2, 5};
        int change = changeII.change(5, coins);
        System.out.println(change);
    }
}
