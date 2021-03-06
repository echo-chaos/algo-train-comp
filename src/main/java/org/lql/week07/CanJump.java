package org.lql.week07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/20 10:05 PM
 * @description: 55. 跳跃游戏 https://leetcode-cn.com/problems/jump-game/
 */
public class CanJump {

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     * 1 <= nums.length <= 3 * 104
     * 0 <= nums[i] <= 105
     */
    private static final Logger logger = LoggerFactory.getLogger(CanJump.class);

    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        CanJump jump = new CanJump();
        boolean b = jump.canJump(nums);
        System.out.println(b);
    }
}
