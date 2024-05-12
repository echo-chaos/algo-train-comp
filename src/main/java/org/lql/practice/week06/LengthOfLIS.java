package org.lql.practice.week06;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/13 22:15
 * @description: 300. 最长递增子序列 <a href="https://leetcode-cn.com/problems/longest-increasing-subsequence/">...</a>
 */
public class LengthOfLIS {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
     * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp,1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        // 4
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        // 4
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3}));
        // 1
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7}));
        // 6
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
        // 6
        System.out.println(lengthOfLIS.lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }
}
