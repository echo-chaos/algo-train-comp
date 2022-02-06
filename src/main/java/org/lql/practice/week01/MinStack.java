package org.lql.practice.week01;

import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/2/2 23:55
 * @description: 155. 最小栈 https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> preMin = new Stack<>();

    public MinStack() {
    }

    void push(int val){
        stack.push(val);
        if (preMin.isEmpty()){
            preMin.push(val);
        } else {
            preMin.push(Math.min(preMin.peek(),val));
        }
    }

    void pop(){
        stack.pop();
        preMin.pop();
    }

    int top(){
        return stack.peek();
    }

    int getMin(){
        return preMin.peek();
    }
}
