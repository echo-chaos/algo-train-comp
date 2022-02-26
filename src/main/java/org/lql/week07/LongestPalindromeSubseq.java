package org.lql.week07;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/20 10:08
 * @description: 516. 最长回文子序列 https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromeSubseq {

    /**
     * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
     * <p>
     * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由小写英文字母组成
     */
    private static final Logger logger = LoggerFactory.getLogger(LongestPalindromeSubseq.class);

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            // 最小的回文字串
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // 相等、[i+1,j-1]是当前遍历到的范围内最长回文字串，再和尚头尾的i、更新长度
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    // 不等、那就取两边最大的那个
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq longestPalindromeSubseq = new LongestPalindromeSubseq();
        int cbbd = longestPalindromeSubseq.longestPalindromeSubseq("cbbd");
        System.out.println(cbbd);
    }
}
