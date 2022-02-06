package org.lql.practice.week01;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/1/3 20:54
 * @description: 224. 基本计算器 https://leetcode-cn.com/problems/basic-calculator/
 */
public class Calculate {

    private Stack<Character> ops = new Stack<>();

    // 中缀转后缀
    public int calculate(String s) {
        s += " ";
        ArrayList<String> tokens = new ArrayList<>();
        String numbers = "";
        boolean needZero = true;
        for (char ch : s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                numbers += ch;
                needZero = false;
                continue;
            } else {
                if (numbers != "") {
                    tokens.add(numbers);
                    numbers = "";
                }
            }
            if (ch == ' ') {
                continue;
            }
            if (ch == '('){
                ops.push(ch);
                needZero = true;
                continue;
            }
            if (ch == ')'){
                while (ops.peek() != '('){
                    tokens.add(ops.pop().toString());
                }
                ops.pop();
                needZero = false;
                continue;
            }
            if ((ch == '+' || ch == '-') && needZero){
                tokens.add("0");
            }
            int rank = getRank(ch);
            while (!ops.isEmpty() && getRank(ops.peek()) >= rank) {
                tokens.add(ops.pop().toString());
            }
            ops.push(ch);
            needZero = true;
        }
        while (!ops.isEmpty()) {
            tokens.add(ops.pop().toString());
        }
        String[] token = new String[tokens.size()];
        for (int i = 0; i < tokens.size(); i++) {
            token[i] = tokens.get(i);
        }
        return evalRPN(token);
    }

    private int getRank(char ch) {
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        }
        return 0;
    }


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
        String s = "(1+(4+5+2)-3)+(6+8)";
//        s = "1 + 1";
        Calculate calculate = new Calculate();
        int calculate1 = calculate.calculate(s);
        System.out.println(calculate1);
    }
}
