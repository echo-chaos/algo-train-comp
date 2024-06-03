package org.lql.hot100.stack;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 14:16
 * @description: 394. 字符串解码 <a href="https://leetcode.cn/problems/decode-string/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class DecodeString {

    /**
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * <p>
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * <p>
     * 示例 3：
     * <p>
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * <p>
     * 示例 4：
     * <p>
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     */


    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentStr = new StringBuilder();
        int currentCount = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 数字可能是多位数
                currentCount = currentCount * 10 + c - '0';
            } else if (c == '[') {
                // 数字压入计数栈,并重置
                numStack.push(currentCount);
                currentCount = 0;
                // 字符串压入字符串栈，并重置
                strStack.push(currentStr);
                currentStr = new StringBuilder();
            } else if (c == ']') {
                // 弹出计数栈和字符串栈，拼接字符串
                int count = numStack.pop();
                StringBuilder temp = strStack.pop();
                for (int i = 0; i < count; i++) {
                    temp.append(currentStr);
                }
                currentStr = temp;
            } else {
                currentStr.append(c);
            }
        }
        return currentStr.toString();
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        // aaabcbc
        System.out.println(decodeString.decodeString("3[a]2[bc]"));
        // accaccacc
        System.out.println(decodeString.decodeString("3[a2[c]]"));
        // abcabccdcdcdef
        System.out.println(decodeString.decodeString("2[abc]3[cd]ef"));
        // abccdcdcdxyz
        System.out.println(decodeString.decodeString("abc3[cd]xyz"));
    }
}
