package org.lql.leetcode;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/6 21:50
 * @description: 215. 数组中的第K个最大元素 https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKthLargest {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 1 <= k <= nums.length <= 104
     * -104 <= nums[i] <= 104
     */

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int kthLargest = findKthLargest.findKthLargest(nums, 2);
        System.out.println(kthLargest);
    }
}
