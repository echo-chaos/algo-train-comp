package org.lql.practice.week06;

/**
 * @author: lql
 * @date: 2022/2/13 22:14
 * @description: 1143. 最长公共子序列 <a href="https://leetcode-cn.com/problems/longest-common-subsequence/">...</a>
 */
public class LongestCommonSubsequence {

    /**
     * 给定两个字符串text1 和text2，
     * 返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
     * <p>
     * 一个字符串的子序列是指这样一个新的字符串：
     * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
     * <p>
     * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
     * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
     * <p>
     * 1 <= text1.length, text2.length <= 1000
     * text1 和 text2 仅由小写英文字符组成。
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        text1 = " " + text1;
        text2 = " " + text2;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        // 3
        System.out.println(lcs.longestCommonSubsequence("abcde", "ace"));
        // 3
        System.out.println(lcs.longestCommonSubsequence("abc", "abc"));
        // 0
        System.out.println(lcs.longestCommonSubsequence("abc", "def"));
    }
}
