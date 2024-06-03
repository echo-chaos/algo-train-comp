package org.lql.hot100.dynamicProgramming;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 16:41
 * @description: 152. 乘积最大子数组 <a href="https://leetcode.cn/problems/maximum-product-subarray/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MaxProduct {

    /**
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续
     * 子数组
     * （该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * <p>
     * 测试用例的答案是一个 32-位 整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -10 <= nums[i] <= 10
     * nums 的任何前缀或后缀的乘积都 保证 是一个 32-位 整数
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        // 初始化动态规划数组，用于记录到当前位置为止的最大乘积
        int[] fMax = new int[n];
        // 初始化动态规划数组，用于记录到当前位置为止的最小乘积
        int[] fMin = new int[n];
        // 初始状态，第一个元素的最大、最小乘积都为其本身
        fMax[0] = nums[0];
        fMin[0] = nums[0];
        for (int i = 1; i < n; i++) {
            // 更新最大乘积，比较三种情况：前一个最大乘积乘以当前元素、前一个最小乘积乘以当前元素、当前元素自身
            fMax[i] = Math.max(fMax[i - 1] * nums[i], Math.max(fMin[i - 1] * nums[i], nums[i]));
            // 更新最小乘积，比较三种情况：前一个最大乘积乘以当前元素、前一个最小乘积乘以当前元素、当前元素自身
            fMin[i] = Math.min(fMax[i - 1] * nums[i], Math.min(fMin[i - 1] * nums[i], nums[i]));
        }
        int ans = fMax[0];
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, fMax[i]);
        }
        return ans;
    }
}
