package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/14 10:09
 * @description: 300. 最长递增子序列 https://leetcode-cn.com/problems/longest-increasing-subsequence/
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
        int n = nums.length;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int i = lengthOfLIS.lengthOfLIS(nums);
        System.out.println(i);
    }
}
