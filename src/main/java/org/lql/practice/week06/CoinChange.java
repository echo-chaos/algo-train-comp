package org.lql.practice.week06;

/**
 * @author: lql
 * @date: 2022/2/13 21:36
 * @description: 322. 零钱兑换 <a href="https://leetcode-cn.com/problems/coin-change/">...</a>
 */
public class CoinChange {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。
     * 如果没有任何一种硬币组合能组成总金额，返回-1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */
    public int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        if (dp[amount] >= Integer.MAX_VALUE) {
            dp[amount] = -1;
        }
        return (int) dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        // 3
        System.out.println(coinChange.coinChange(new int[]{1, 2, 5}, 11));
        // -1
        System.out.println(coinChange.coinChange(new int[]{2}, 3));
        // 0
        System.out.println(coinChange.coinChange(new int[]{1}, 0));
    }
}
