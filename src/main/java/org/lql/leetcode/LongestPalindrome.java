package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/3/6 23:22
 * @description: 5. 最长回文子串 https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {

    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * <p>
     * 1 <= s.length <= 1000
     * s 仅由数字和英文字母组成
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        int ansLen = 0;
        int ansStart = 0;
        // 奇
        for (int i = 0; i < n; i++) {
            int l = i - 1;
            int r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // l + 1 ~ r - 1 : i 为中心
            if (r - l - 1 > ansLen) {
                ansLen = r - l - 1;
                ansStart = l + 1;
            }
        }
        // 偶
        for (int i = 1; i < n; i++) {
            int l = i - 1;
            int r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            // l + 1 ~ r - 1 : i-1与i为中心
            if (r - l - 1 > ansLen) {
                ansLen = r - l - 1;
                ansStart = l + 1;
            }
        }
        return s.substring(ansStart, ansStart+ansLen);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String cbbd = longestPalindrome.longestPalindrome("cbbd");
        System.out.println(cbbd);
    }
}
