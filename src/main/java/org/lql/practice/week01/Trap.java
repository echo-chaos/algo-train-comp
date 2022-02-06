package org.lql.practice.week01;

import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/1/3 16:45
 * @description: 42. 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Trap {

    private class Rect {
        int width;
        int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    private Stack<Rect> stack = new Stack<>();

    public int trap(int[] height) {
        int ans = 0;
        for (int h : height) {
            int accumulatedWidth = 0;
            while (!stack.isEmpty() && stack.peek().height <= h) {
                int bottom = stack.peek().height;
                accumulatedWidth += stack.peek().width;
                stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                // 以bottom为底的水最高可到up（左右两侧高度的min）
                int up = Math.min(h, stack.peek().height);
                ans += accumulatedWidth * (up - bottom);
            }
            stack.push(new Rect(accumulatedWidth + 1, h));
        }
        return ans;
    }

    private int[] preMax;
    private int[] sufMax;

    public int trapA(int[] height) {
        int n = height.length;
        preMax = new int[n];
        sufMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int up = Math.min(preMax[i - 1], sufMax[i + 1]);
            int bottom = height[i];
            if (up > bottom) {
                ans += up - bottom;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Trap trap = new Trap();
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap.trap(height));
        System.out.println(trap.trapA(height));
    }
}
