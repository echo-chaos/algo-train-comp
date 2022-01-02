package org.lql.leetcode;

import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/1/2 14:17
 * @description: 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     * <p>
     * push(x) —— 将元素 x 推入栈中。
     * pop() —— 删除栈顶的元素。
     * top() —— 获取栈顶元素。
     * getMin() —— 检索栈中的最小元素。
     */

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MinStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();
    }

    public void push(int val) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(val);
        } else if (val <= this.getMin()) {
            this.stackMin.push(val);
        }
        this.stackData.push(val);
    }

    public void pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
    }

    public int top() {
        return this.stackData.peek();
    }

    public int getMin() {
        if (this.stackMin.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return this.stackMin.peek();
    }
}
