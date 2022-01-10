package org.lql.practice.week02;

/**
 * @author: lql
 * @date: 2022/1/3 22:40
 * @description: 11. 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        int ans = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, area);
            if (height[left] >= height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int i = maxArea.maxArea(height);
        System.out.println(i);
    }
}
