package org.lql.practice.week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: lql
 * @date: 2022/2/13 20:53
 * @description: 239. 滑动窗口最大值 <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">...</a>
 */
public class MaxSlidingWindowByPriority {

    /**
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     * <p>
     * 返回 滑动窗口中的最大值 。
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     * 1 <= k <= nums.length
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        // 优先队列：重写compare
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> b.value - a.value);
        for (int i = 0; i < nums.length; i++) {
            // 将数组元素按照：值-下标的方式入队
            queue.add(new Pair(nums[i], i));
            // 到达窗口大小，维护窗口元素
            if (i >= k - 1) {
                // 移除窗口外的元素，确保队列内都是窗口中的元素
                while (!queue.isEmpty() && queue.peek().index <= i - k) {
                    queue.poll();
                }
                // 将堆顶元素添加到ans中
                ans.add(queue.peek().value);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private static class Pair {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        MaxSlidingWindowByPriority maxSlidingWindow = new MaxSlidingWindowByPriority();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
