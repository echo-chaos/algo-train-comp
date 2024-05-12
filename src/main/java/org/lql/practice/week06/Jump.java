package org.lql.practice.week06;

/**
 * @author: lql
 * @date: 2022/2/13 22:09
 * @description: 45. 跳跃游戏 II <a href="https://leetcode-cn.com/problems/jump-game-ii/">...</a>
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
    /**
     * [2,  3,      1,      1,      4]
     *  0   1       2       3       4
     * now
     *      now+1   right
     *      next                    nextRight
     */
    public int jump(int[] nums) {
        int now = 0;
        int ans = 0;
        while (now < nums.length) {
            // [now + 1, right] 当前可达范围
            int right = now + nums[now];
            // 如果已经到达边界，则返回
            if (right >= nums.length - 1) {
                return ans + 1;
            }
            // 下一步的可达边界-> nextRight
            int nextRight = right;
            int next = 0;
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
