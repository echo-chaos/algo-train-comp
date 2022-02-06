package org.lql.practice.week01;

import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/2/2 23:54
 * @description: 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class IsValid {

    private Stack<Character> stack = new Stack<>();

    public boolean isValid(String s) {
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.pop() != '(') {
                    return false;
                }
                if (ch == ']' && stack.pop() != '[') {
                    return false;
                }
                if (ch == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValid isValid = new IsValid();
        String s = "()[({})]";
        boolean valid = isValid.isValid(s);
        System.out.println(valid);
    }
}
