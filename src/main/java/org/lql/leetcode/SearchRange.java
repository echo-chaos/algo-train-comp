package org.lql.leetcode;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/26 22:27
 * @description: 34. 在排序数组中查找元素的第一个和最后一个位置 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class SearchRange {

    /**
     * 二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        //寻找左边界(这里寻找第一个 >= target的索引)
        int leftIndex = search(nums, target);
        if (leftIndex >= nums.length || nums[leftIndex] != target) {
            return new int[]{-1, -1};
        }
        //寻找右边界(这里寻找第一个 >= target+1的索引)
        int rightIndex = search(nums, target + 1);
        return new int[]{leftIndex, rightIndex - 1};
    }

    /**
     * 寻找第一个>=目标值的索引, 找不到则返回数组长度
     */
    private int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] ints = searchRange.searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
