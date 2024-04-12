package org.lql.practice.week02;

/**
 * @author: lql
 * @date: 2022/1/3 22:40
 * @description: 11. 盛最多水的容器 <a href="https://leetcode-cn.com/problems/container-with-most-water/">...</a>
 */
public class MaxArea {

    public int maxArea(int[] height) {
        // 边界判断
        if (height.length < 2) {
            return 0;
        }
        // 结果
        int ans = 0;
        // 左右双指针
        int left = 0;
        int right = height.length - 1;
        // 两个指针不相遇
        while (left < right) {
            // 计算当前容器面积
            int area = Math.min(height[left], height[right]) * (right - left);
            // 更新结果
            ans = Math.max(ans, area);
            // 移动左右指针
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
