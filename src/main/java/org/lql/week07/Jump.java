package org.lql.week07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/20 10:06 PM
 * @description: 45. 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少跳跃次数到达数组的最后一个位置。
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     */
    private static final Logger logger = LoggerFactory.getLogger(Jump.class);

    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = n + 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Jump jump = new Jump();
        int i = jump.jump(nums);
        System.out.println(i);
    }
}
