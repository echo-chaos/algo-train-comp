package org.lql.practice.week04;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: lql
 * @date: 2022/2/13 20:53
 * @description: 239. 滑动窗口最大值 <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">...</a>
 */
public class MaxSlidingWindow {

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
        // 用于存储结果的列表
        List<Integer> ans = new ArrayList<>();
        // 使用优先队列来存储窗口中的元素，以便快速找到最大值
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        // 双向队列来维护当前窗口的元素，确保元素的顺序
        Deque<int[]> window = new ArrayDeque<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 当前元素及其索引
            int[] current = new int[]{nums[i], i};
            window.addLast(current);
            pq.add(current);

            // 当窗口达到指定大小时，维护窗口和优先队列的状态
            if (i >= k - 1) {
                // 移除窗口外的元素
                while (!window.isEmpty() && window.getFirst()[1] <= i - k) {
                    window.removeFirst();
                }
                // 移除不在窗口内的元素，确保优先队列中的元素都是窗口内的
                while (!pq.isEmpty() && !window.contains(pq.peek())) {
                    pq.poll();
                }
                // 添加当前窗口的最大值到结果列表
                ans.add(pq.peek()[0]);
            }
        }

        // 将结果列表转换为整型数组返回
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
