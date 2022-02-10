package org.lql.leetcode;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/9 23:01
 * @description: 322. 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 */
public class CoinChange {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;
        int i = coinChange.coinChange(coins, amount);
        System.out.println(i);
    }
}
