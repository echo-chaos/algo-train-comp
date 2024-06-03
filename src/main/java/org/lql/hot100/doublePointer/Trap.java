package org.lql.hot100.doublePointer;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 22:27
 * @description: 42. 接雨水 <a href="https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Trap {

    /**
     * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * 示例 1：
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 示例 2：
     * <p>
     * 输入：height = [4,2,0,3,2,5]
     * 输出：9
     * <p>
     * 提示：
     * <p>
     * n == height.length
     * 1 <= n <= 2 * 104
     * 0 <= height[i] <= 105
     */

    static class Rect {
        int width;
        int height;

        public Rect(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    private static final Stack<Rect> stack = new Stack<>();

    public int trap(int[] height) {
        int ans = 0;
        for (int h : height) {
            // 累加宽度
            int accumulatedWidth = 0;
            // 单调递减栈的单调性被破坏，计算当前雨水容量
            while (!stack.isEmpty() && stack.peek().height <= h) {
                Rect rect = stack.pop();
                int bottom = rect.height;
                accumulatedWidth += rect.width;
                // 栈为空时，说明当前柱子没有左侧柱子，无法接雨水
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

    public static void main(String[] args) {
        // 6
        System.out.println(new Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        // 9
        System.out.println(new Trap().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}
