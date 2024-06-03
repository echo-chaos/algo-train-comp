package org.lql.hot100.stack;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 14:14
 * @description: 155. 最小栈 <a href="https://leetcode.cn/problems/min-stack/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MinStack {

    // 正常存数据的栈
    private final Stack<Integer> stack;
    // 存当前最小值的栈
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
