package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/3/2 22:44
 * @description: 28. 实现 strStr() https://leetcode-cn.com/problems/implement-strstr/
 */
public class StrStr {

    /**
     * 实现strStr()函数。
     * <p>
     * 给你两个字符串haystack 和 needle ，
     * 请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
     * <p>
     * 说明：
     * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
     * <p>
     * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
     * <p>
     * 0 <= haystack.length, needle.length <= 5 * 104
     * haystack 和 needle 仅由小写英文字符组成
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        String haystack = "hello";
        String needle = "ll";
        int i = str.strStr(haystack, needle);
        System.out.println(i);
    }
}
