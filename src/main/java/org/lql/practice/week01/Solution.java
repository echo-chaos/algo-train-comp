package org.lql.practice.week01;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: <a href="https://leetcode.cn/problems/basic-calculator-ii/description/">227 基本计算器 II</a>
 * @author: liangqinglong
 * @date: 2024-03-15 23:44
 **/
public class Solution {

    // 操作数栈
    private final Stack<Character> ops = new Stack<>();

    // 后缀表达式计算使用栈
    private final Stack<Integer> calculateStack = new Stack<>();

    public int calculate(String s) {
        // 表达式后加空格作为结束标志,能够让累计的数字字符放入tokens中
        s += " ";
        // 表达式的内容数组
        List<String> tokens = new ArrayList<>();
        // 表达式中的数字部分
        String number = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 判断是否为数字
            if (ch >= '0' && ch <= '9') {
                number += ch;
                continue;
            } else {
                // 表达式数字不为空
                if (!number.isEmpty()) {
                    // 当遇到符号时，判断number不为空，放入tokens，将number重置
                    tokens.add(number);
                    number = "";
                }
            }
            // 判断字符是否为空，为空的话跳过
            if (ch == ' ') {
                continue;
            }
            // 计算运算符等级
            int currentRank = getRank(ch);
            // 运算符栈不为空，且栈顶运算符等级大于等于当前运算符等级，将运算符弹出添加到tokens中
            while (!ops.isEmpty() && getRank(ops.peek()) >= currentRank) {
                tokens.add(ops.pop().toString());
            }
            // 当前运算符入栈
            ops.push(ch);
        }
        // 弹出剩余的运算符并添加到tokens中
        while (!ops.isEmpty()) {
            tokens.add(ops.pop().toString());
        }
        // 将tokens转换为数组,并赋值
        String[] token = new String[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            token[i] = tokens.get(i);
        }
        return evalRPN(token);
    }

    public int getRank(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int y = calculateStack.pop();
                int x = calculateStack.pop();
                int result = calculate(x, y, token);
                calculateStack.push(result);
            } else {
                calculateStack.push(Integer.valueOf(token));
            }
        }
        return calculateStack.pop();
    }

    private int calculate(int x, int y, String token) {
        int result = 0;
        switch (token) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
                result = x / y;
                break;
            default:
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "3+2*2";
        System.out.println(solution.calculate(s));
    }
}
