package org.lql.week06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/10 23:30
 * @description: 673. 最长递增子序列的个数 https://leetcode-cn.com/problems/number-of-longest-increasing-subsequence/
 */
public class FindNumberOfLIS {

    /**
     * 给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。
     * <p>
     * 注意 这个数列必须是 严格 递增的。
     * <p>
     * 1 <= nums.length <= 2000
     * -106 <= nums[i] <= 106
     */
    private static final Logger logger = LoggerFactory.getLogger(FindNumberOfLIS.class);

    public int findNumberOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        // dp-> 最长增长子序长度
        int[] dp = new int[n];
        // cnt -> dp对应子序个数
        int[] cnt = new int[n];
        // 最大长度
        int maxLen = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // 没找着，更新dp长度更新，cnt计数为上一个长度
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        cnt[i] = cnt[j];
                        // 找到长度一致，cnt计数加上j
                    } else if (dp[i] == dp[j] + 1) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            // 每次扫描完成一次，更新maxLen以及ans
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                ans = cnt[i];
            } else if (dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        logger.info("dp  -> {}", Arrays.toString(dp));
        logger.info("cnt -> {}", Arrays.toString(cnt));
        return ans;
    }

    public static void main(String[] args) {
        FindNumberOfLIS lis = new FindNumberOfLIS();
        int[] nums = {1, 3, 5, 4, 7};
        int ans = lis.findNumberOfLIS(nums);
        logger.info("ans -> {}", ans);
    }
}
