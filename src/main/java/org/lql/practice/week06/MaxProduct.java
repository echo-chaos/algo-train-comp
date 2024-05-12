package org.lql.practice.week06;

/**
 * @author: lql
 * @date: 2022/2/13 22:17
 * @description: 152. 乘积最大子数组 <a href="https://leetcode-cn.com/problems/maximum-product-subarray/">...</a>
 */
public class MaxProduct {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
     * 并返回该子数组所对应的乘积。
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMin = new int[n];
        fMax[0] = nums[0];
        fMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            fMax[i] = Math.max(fMax[i - 1] * nums[i], Math.max(fMin[i - 1] * nums[i], nums[i]));
            fMin[i] = Math.min(fMax[i - 1] * nums[i], Math.min(fMin[i - 1] * nums[i], nums[i]));
        }
        int ans = fMax[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, fMax[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        // 6
        System.out.println(maxProduct.maxProduct(new int[]{2, 3, -2, 4}));
        // 0
        System.out.println(maxProduct.maxProduct(new int[]{-2, 0, -1}));
    }
}
