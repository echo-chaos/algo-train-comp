package org.lql.practice.week01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/1/3 16:44
 * @description: 84. 柱状图中最大的矩形 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        int[] temp = new int[heights.length + 2];
        System.arraycopy(heights, 0, temp, 1, heights.length);
        heights = temp;
        System.out.println(Arrays.toString(heights));
        stack.addLast(0);
        for (int i = 1; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] > heights[i]) {
                int height = heights[stack.removeLast()];
                int width = i - stack.peekLast() - 1;
                ans = Math.max(ans, width * height);
            }
            stack.addLast(i);
        }
        return ans;
    }

    public int largestRectangleAreaA(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[heights.length + 1];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        heights = temp;
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                if (!stack.isEmpty()) {
                    ans = Math.max(ans, height * (i - stack.peek() - 1));
                } else {
                    ans = Math.max(ans, height * i);
                }
            }
            stack.push(i);
        }
        return ans;
    }

    private class Rect {
        int width;
        int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    private Stack<Rect> stack = new Stack<>();

    public int largestRectangleAreaB(int[] heights) {
        int ans = 0;
        int[] temp = new int[heights.length + 1];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        temp[temp.length - 1] = 0;
        heights = temp;
        for (int height : heights) {
            int accumulatedWidth = 0;
            while (!stack.isEmpty() && stack.peek().height >= height){
                accumulatedWidth += stack.peek().width;
                ans = Math.max(ans,stack.peek().height*accumulatedWidth);
                stack.pop();
            }
            stack.push(new Rect(accumulatedWidth+1,height));
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea rectangleArea = new LargestRectangleArea();
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println(rectangleArea.largestRectangleArea(heights));
        System.out.println(rectangleArea.largestRectangleAreaA(heights));
        System.out.println(rectangleArea.largestRectangleAreaB(heights));
    }
}
