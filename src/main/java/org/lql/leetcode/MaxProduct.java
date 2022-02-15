package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/15 10:14 PM
 * @description: 152. 乘积最大子数组 https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class MaxProduct {

    /**
     * 给你一个整数数组 nums，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个32-位 整数。
     * <p>
     * 子数组 是数组的连续子序列。
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证是一个 32-位 整数
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fmax = new int[n];
        int[] fmin = new int[n];
        fmax[0] = nums[0];
        fmin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            fmax[i] = Math.max(Math.max(fmax[i - 1] * nums[i], fmin[i - 1] * nums[i]), nums[i]);
            fmin[i] = Math.min(Math.min(fmax[i - 1] * nums[i], fmin[i - 1] * nums[i]), nums[i]);
        }
        int ans = fmax[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, fmax[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int[] nums = {2, 3, -2, 4};
        int i = maxProduct.maxProduct(nums);
        System.out.println(i);
    }
}
