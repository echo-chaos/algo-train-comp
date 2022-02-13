package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/10 21:53
 * @description: 122. 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class MaxProfit {

    /**
     * 给定一个数组 prices ，其中prices[i] 表示股票第 i 天的价格。
     * <p>
     * 在每一天，你可能会决定购买和/或出售股票。你在任何时候最多只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润。
     * <p>
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += Math.max(prices[i] - prices[i - 1], 0);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProfit maxProfit = new MaxProfit();
        int[] prices = {7, 1, 5, 3, 6, 4};
        int i = maxProfit.maxProfit(prices);
        System.out.println(i);
    }
}
