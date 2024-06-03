package org.lql.hot100.dynamicProgrammingMulti;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 17:23
 * @description: 5. 最长回文子串 <a href="https://leetcode.cn/problems/longest-palindromic-substring/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LongestPalindrome {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "cbbd"
     * 输出："bb"
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;
        // 初始化长度为1的子串为回文
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;  // 单个字符是回文
        }

        // 检查长度为2的子串，同时更新最长回文子串的起始位置和长度
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }
        // 从长度为3开始，逐步扩展检查更长的子串
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                // 如果当前字符和对称字符相同，并且去掉这两个字符的子串也是回文，则当前子串也是回文
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("cbbd"));
    }
}
