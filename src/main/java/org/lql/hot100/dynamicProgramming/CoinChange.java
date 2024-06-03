package org.lql.hot100.dynamicProgramming;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 15:50
 * @description: 322. 零钱兑换 <a href="https://leetcode.cn/problems/coin-change/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class CoinChange {

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     * <p>
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * <p>
     * 你可以认为每种硬币的数量是无限的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * <p>
     * 示例 2：
     * <p>
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * <p>
     * 示例 3：
     * <p>
     * 输入：coins = [1], amount = 0
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 1 <= coins.length <= 12
     * 1 <= coins[i] <= 231 - 1
     * 0 <= amount <= 104
     */
    public int coinChange(int[] coins, int amount) {
        /**
         * dp数组用于存储组成不同金额所需的最少硬币数量。
         * dp[i] 表示组成金额 i 所需的最少硬币数量。
         * 初始化为 Integer.MAX_VALUE 表示初始状态下任何金额都无法组成。
         */
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            /**
             * 遍历每种硬币，尝试使用当前硬币来组成金额 i。
             * 如果金额 i 减去当前硬币的面额大于等于 0，
             * 表示可以使用当前硬币来组成金额 i。
             */
            for (int coin : coins) {
                if (i - coin >= 0) {
                    /**
                     * 更新 dp[i] 的值为当前值和使用当前硬币组成金额 i-coin 所需硬币数量加 1 的较小值。
                     * 这里使用了动态规划的思想，通过逐步分解目标金额并利用已知的子问题结果，
                     * 来求解组成总金额的最少硬币数量。
                     */
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        /**
         * 最后检查 dp[amount] 的值是否仍为初始值 Integer.MAX_VALUE，
         * 如果是，则表示无法组成总金额，返回 -1；否则返回 dp[amount]。
         */
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins, amount));
    }
}
