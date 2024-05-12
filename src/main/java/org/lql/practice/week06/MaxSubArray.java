package org.lql.practice.week06;

/**
 * @author: lql
 * @date: 2022/2/13 22:16
 * @description: 53. 最大子数组和 <a href="https://leetcode-cn.com/problems/maximum-subarray/">...</a>
 */
public class MaxSubArray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 子数组 是数组中的一个连续部分。
     * <p>
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = nums[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1], 0) + nums[i];
        }
        int ans = f[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        // 6
        System.out.println(maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // 1
        System.out.println(maxSubArray.maxSubArray(new int[]{1}));
        // 23
        System.out.println(maxSubArray.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
