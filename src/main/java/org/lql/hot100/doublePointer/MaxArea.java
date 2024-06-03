package org.lql.hot100.doublePointer;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 21:27
 * @description: 11. 盛最多水的容器 <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MaxArea {

    /**
     * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
     * <p>
     * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 返回容器可以储存的最大水量。
     * <p>
     * 说明：你不能倾斜容器。
     * 示例 1：
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 示例 2：
     * <p>
     * 输入：height = [1,1]
     * 输出：1
     */
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int area = (right - left) * minHeight;
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // 49
        System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        // 1
        System.out.println(new MaxArea().maxArea(new int[]{1, 1}));
        // 2
        System.out.println(new MaxArea().maxArea(new int[]{1, 2, 1}));
    }
}
