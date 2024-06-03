package org.lql.hot100.dynamicProgramming;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 16:31
 * @description: 300. 最长递增子序列 <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LengthOfLIS {

    /**
     * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
     * <p>
     * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [10,9,2,5,3,7,101,18]
     * 输出：4
     * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,0,3,2,3]
     * 输出：4
     * <p>
     * 示例 3：
     * <p>
     * 输入：nums = [7,7,7,7,7,7,7]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2500
     * -104 <= nums[i] <= 104
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // 初始化dp数组，每个元素初始值为1，因为至少每个元素本身可以构成一个递增子序列
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            // 对于当前位置i，检查之前的每个位置j
            for (int j = 0; j < i; j++) {
                // 如果当前位置的值大于之前的位置的值，说明可以将当前位置加入到之前的递增子序列中
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        // 统计最长递增子序列的长度
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
