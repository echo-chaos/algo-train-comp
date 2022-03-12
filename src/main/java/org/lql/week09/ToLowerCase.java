package org.lql.week09;

/**
 * @author: lql
 * @date: 2022/2/28 1:49 AM
 * @description: 709. 转换成小写字母 https://leetcode-cn.com/problems/to-lower-case/
 */
public class ToLowerCase {

    /**
     * 给你一个字符串 s ，将该字符串中的大写字母转换成相同的小写字母，返回新的字符串。
     * <p>
     * 1 <= s.length <= 100
     * s 由 ASCII 字符集中的可打印字符组成
     *
     * A - Z ~ [65,90]
     * a - z ~ [97,122]
     */
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch |= 32;
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ToLowerCase lowerCase = new ToLowerCase();
        String lovely = lowerCase.toLowerCase("LOVELY");
        System.out.println(lovely);
    }
}
