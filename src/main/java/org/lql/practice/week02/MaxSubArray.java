package org.lql.practice.week02;

/**
 * @author: lql
 * @date: 2022/1/3 22:38
 * @description: 53. 最大子数组和 https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        int[] preMin = new int[n + 1];
        // 前缀和
        for (int i = 1; i <= n; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }
        // 前缀和最小值
        preMin[0] = s[0];
        for (int i = 1; i <= n; i++) {
            preMin[i] = Math.min(preMin[i - 1], s[i]);
        }
        int ans = -100000;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, s[i] - preMin[i - 1]);
        }
        return ans;
    }

    // 解法2，贪心，和为正就向右扩展，一旦为负，便舍弃

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int array = maxSubArray.maxSubArray(nums);
        System.out.println(array);
    }
}
