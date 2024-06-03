package org.lql.hot100.stack;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 14:12
 * @description: 20. 有效的括号 <a href="https://leetcode.cn/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class IsValid {

    private final Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() == '(') {
                    return false;
                } else if (c == ']' && stack.pop() == '[') {
                    return false;
                } else if (c == '}' && stack.pop() == '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
