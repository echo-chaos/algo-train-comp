package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/3/3 23:10
 * @description: 125. 验证回文串 https://leetcode-cn.com/problems/valid-palindrome/
 */
public class IsPalindrome {

    /**
     * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
     * <p>
     * 说明：本题中，我们将空字符串定义为有效的回文串。
     * <p>
     * 1 <= s.length <= 2 * 105
     * 字符串 s 由 ASCII 字符组成
     */
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome palindrome = new IsPalindrome();
        String s = "A man, a plan, a canal: Panama";
        boolean res = palindrome.isPalindrome(s);
        System.out.println(res);
    }
}
