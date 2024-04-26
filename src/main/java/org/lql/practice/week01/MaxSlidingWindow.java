package org.lql.practice.week01;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/3 16:46
 * @description: 239. 滑动窗口最大值 <a href="https://leetcode-cn.com/problems/sliding-window-maximum/">...</a>
 */
public class MaxSlidingWindow {

    // 下标
    private Deque<Integer> q = new ArrayDeque<>();

    public int[] maxSlidingWindow(int[] nums, int k) {
        // 下标（时间递增）值递减的队列
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 删除出界选项
            while (!q.isEmpty() && q.getFirst() <= i - k) {
                q.pollFirst();
            }
            // 插入新选项i，维护单调性
            while (!q.isEmpty() && nums[q.peekLast()] <= nums[i]) {
                q.pop();
            }
            q.push(i);
            // 取队头更新答案
            if (i >= k - 1) {
                ans.add(nums[q.getFirst()]);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
