package org.lql.hot100.dynamicProgramming;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 16:59
 * @description: 32. 最长有效括号 <a href="https://leetcode.cn/problems/longest-valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LongestValidParentheses {

    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
     * 子串
     * 的长度。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * <p>
     * 示例 3：
     * <p>
     * 输入：s = ""
     * 输出：0
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 3 * 104
     * s[i] 为 '(' 或 ')'
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        // 初始化动态规划数组，dp[i] 表示以第 i 个字符结尾的最长有效括号子串的长度
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    // 如果当前字符是 '('，则表示当前有效括号长度为 dp[i-2] + 2
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 如果当前字符前有一个有效的括号子串，且该子串前有一个 '('，则可以形成更长的有效括号子串
                    // 更新 dp[i] 为前一个括号子串的 dp 值加上当前子串前的括号对长度加2
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public int longestValidParenthesesA(String s) {
        int len = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                // 如果栈为空，说明当前右括号没有匹配的左括号，将当前右括号的索引入栈
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // 如果栈不为空，计算当前有效子串的长度，并更新最长有效括号长度
                    len = Math.max(len, i - stack.peek());
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses("(()"));
        System.out.println(longestValidParentheses.longestValidParentheses(")()())"));
        System.out.println(longestValidParentheses.longestValidParentheses(""));
    }

}
