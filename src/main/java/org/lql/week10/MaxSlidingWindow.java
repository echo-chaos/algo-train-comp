package org.lql.week10;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/3/17 21:17
 * @description: 239. 滑动窗口最大值 https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class MaxSlidingWindow {

    /**
     * 给你一个整数数组 nums，
     * 有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回 滑动窗口中的最大值 。
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        return new int[]{};
    }

    public static void main(String[] args) {
        MaxSlidingWindow window = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = window.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
