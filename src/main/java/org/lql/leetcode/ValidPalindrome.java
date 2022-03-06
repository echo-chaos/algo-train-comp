package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/3/6 23:20
 * @description: 680. 验证回文字符串 Ⅱ https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class ValidPalindrome {

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     * <p>
     * 1 <= s.length <= 105
     * s 由小写英文字母组成
     */
    public boolean validPalindrome(String s) {
        return check(s, 0, s.length() - 1, 1);
    }

    private boolean check(String s, int l, int r, int time) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return time > 0 && (check(s, l + 1, r, 0) || check(s, l, r - 1, 0));
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean aba = validPalindrome.validPalindrome("abc");
        System.out.println(aba);
    }
}
