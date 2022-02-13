package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/11 21:29
 * @description: 45. 跳跃游戏 II https://leetcode-cn.com/problems/jump-game-ii/
 */
public class Jump {

    /**
     * 给你一个非负整数数组nums ，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     */
    public int jump(int[] nums) {
        int now = 0;
        int ans = 0;
        while (now < nums.length - 1) {
            int right = now + nums[now];
            // [now + 1, right]可达范围
            if (right >= nums.length - 1) {
                return ans + 1;
            }
            int nextRight = right;
            int next = now;
            for (int i = now + 1; i <= right; i++) {
                if (i + nums[i] > nextRight) {
                    nextRight = i + nums[i];
                    next = i;
                }
            }
            now = next;
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int[] nums = {2, 3, 1, 1, 4};
        int i = jump.jump(nums);
        System.out.println(i);
    }
}
