package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2021/12/31 14:58
 * @description: 20. 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Valid {

    /**
     * <p>题目</p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     *
     * <p>有效字符串需满足：</p>
     * <li>左括号必须用相同类型的右括号闭合。</li>
     * <li>左括号必须以正确的顺序闭合。</li>
     *
     * <p>示例 </p>
     * <li>输入：s = "()" 输出：true</li>
     * <li>输入：s = "()[]{}" 输出：true</li>
     * <li>输入：s = "(]" 输出：false</li>
     * <li>输入：s = "([)]" 输出：false</li>
     * <li>输入：s = "{[]}" 输出：true</li>
     *
     * <p>提示：</p>
     * <li>1 <= s.length <= 104</li>
     * <li>s 仅由括号 '()[]{}' 组成</li>
     */
    public static void main(String[] args) {
        String s = "()()()()()";
        boolean valid = isValidStack(s);
        System.out.println(valid);
        System.out.println(isValidQueue(s));
    }

    public static boolean isValidStack(String s) {
        //边界判断 奇数不符合
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidQueue(String s) {
        //边界判断 奇数不符合
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> brackets = new HashMap<Character, Character>(3) {
            {
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }
        };
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (brackets.containsKey(ch)) {
                if (queue.isEmpty() || !queue.peek().equals(brackets.get(ch))) {
                    return false;
                }
                queue.pop();
            } else {
                queue.push(ch);
            }
        }
        return queue.isEmpty();
    }

}
