package org.lql.hot100.array;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-05-23 16:04
 * @description: 238. 除自身以外数组的乘积 <a href="https://leetcode.cn/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class ProductExceptSelf {

    /**
     * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
     * <p>
     * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
     * <p>
     * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 示例 2:
     * <p>
     * 输入: nums = [-1,1,0,-3,3]
     * 输出: [0,0,9,0,0]
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 105
     * -30 <= nums[i] <= 30
     * 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    temp *= nums[j];
                }
            }
            res[i] = temp;
        }
        return res;
    }

    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        // 计算每个元素左边所有元素的乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        // 计算每个元素右边所有元素的乘积，并与之前计算的结果相乘，得到最终答案
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf1(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new ProductExceptSelf().productExceptSelf1(new int[]{-1, 1, 0, -3, 3})));
    }
}
