package org.lql.hot100.array;

/**
 * @author: liangqinglong
 * @date: 2024-05-23 14:40
 * @description: 53. 最大子数组和 <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MaxSubArray {

    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组是数组中的一个连续部分。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     * <p>
     * 提示：
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
        // 6
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // 1
        System.out.println(new MaxSubArray().maxSubArray(new int[]{1}));
        // 23
        System.out.println(new MaxSubArray().maxSubArray(new int[]{5, 4, -1, 7, 8}));
        // 1
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2, 1}));
    }
}
