package org.lql.hot100.binarySearch;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-05-31 15:47
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置 <a href="https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SearchRange {

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     * <p>
     * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例 2：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     * nums 是一个非递减数组
     * -109 <= target <= 109
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
        if (ans[0] > ans[1]) {
            return new int[]{-1, -1};
        }
        return ans;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange.searchRange(nums, target)));
    }
}
