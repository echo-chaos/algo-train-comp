package org.lql.hot100.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 15:42
 * @description: 84. 柱状图中最大的矩形 <a href="https://leetcode.cn/problems/largest-rectangle-in-histogram/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LargestRectangleArea {

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * <p>
     * 示例 1:
     * <p>
     * 输入：heights = [2,1,5,6,2,3]
     * 输出：10
     * <p>
     * 示例 2：
     * <p>
     * 输入： heights = [2,4]
     * 输出： 4
     * <p>
     * 提示：
     * <p>
     * 1 <= heights.length <=105
     * 0 <= heights[i] <= 104
     */
    private static class Rect {
        int width;
        int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    private final Stack<Rect> stack = new Stack<>();

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        heights = Arrays.copyOf(heights, n + 1);
        int ans = 0;
        for (int height : heights) {
            // 累加宽度
            int accumulatedWidth = 0;
            // 栈不空，单调性破坏
            while (!stack.isEmpty() && stack.peek().height > height) {
                Rect rect = stack.pop();
                // 更新累加宽度
                accumulatedWidth += rect.width;
                ans = Math.max(ans, accumulatedWidth * rect.height);
            }
            stack.push(new Rect(accumulatedWidth + 1, height));
        }
        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 4}));
    }
}
