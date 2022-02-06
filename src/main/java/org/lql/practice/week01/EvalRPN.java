package org.lql.practice.week01;

import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/1/3 20:53
 * @description: 150. 逆波兰表达式求值 https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {

    private Stack<Integer> stack = new Stack<>();

    public int evalRPN(String[] tokens) {
        for (String token : tokens) {
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                int y = stack.pop();
                int x = stack.pop();
                int calculate = calculate(x, y, token);
                stack.push(calculate);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
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
        EvalRPN evalRPN = new EvalRPN();
//        String[] tokens = {"2", "1", "+", "3", "*"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = evalRPN.evalRPN(tokens);
        System.out.println(i);
    }
}
