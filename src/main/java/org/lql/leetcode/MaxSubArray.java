package org.lql.leetcode;

import java.text.SimpleDateFormat;

/**
 * @author: lql
 * @date: 2022/1/7 10:13
 * @description: 53. 最大子数组和  https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {


    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     */

    /**
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     *
     * 输入：nums = [1]
     * 输出：1
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     */

    /**
     * 1 <= nums.length <= 105
     * -104 <= nums[i] <= 104
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp[i] = Math.max(temp[i - 1] + nums[i], nums[i]);
            res = Math.max(res, temp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray.maxSubArray(nums);
        System.out.println(i);
    }
}
