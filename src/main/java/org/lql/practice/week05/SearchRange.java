package org.lql.practice.week05;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/13 21:12
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置 <a href="https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/">...</a>
 */
public class SearchRange {

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
     *
     * <p>
     * 0 <= nums.length <= 105
     * -109<= nums[i]<= 109
     * nums是一个非递减数组
     * -109<= target<= 109
     */
    public int[] searchRange(int[] nums, int target) {
        // 开始位置：第一个>=target
        // 结束位置：最后一个<=target
        int left = 0;
        int right = nums.length;
        int[] ans = new int[2];
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        ans[0] = right;
        left = -1;
        right = nums.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        ans[1] = right;
        // 不存在
        if (ans[0] > ans[1]) {
            return new int[]{-1, -1};
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
