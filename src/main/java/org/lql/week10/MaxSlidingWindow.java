package org.lql.week10;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

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
    /**
     * 1, 3, -1, -3, 5, 3, 6, 7 | 3
     *
     * 1 3 -1 -> 3 => 3
     *
     * 3 -1 -3 -> 3 => 3 3
     *
     * -1 -3 5 -> 5 => 3 3 5
     *
     * -3 5 3 -> 5 => 3 3 5 5
     *
     * 5 3 6 -> 6 => 3 3 5 5 6
     *
     * 3 6 7 -> 7 => 3 3 5 5 6 7
     *
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            // 队列不空 && 队尾元素小于新元素，舍弃队尾元素 -> 保持队列递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        // n - k + 1 => 窗口在数组中所要滑动的次数
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            // 队列不空 && 队尾元素小于新元素，舍弃队尾元素 -> 保持队列递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // 保证队列元素不超过k+1个
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            // 取当前窗口最大值添加到答案中
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSlidingWindow window = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = window.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
