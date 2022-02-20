package org.lql.practice.week07;

/**
 * @author: lql
 * @date: 2022/2/20 10:33 PM
 * @description: 1499. 满足不等式的最大值 https://leetcode-cn.com/problems/max-value-of-equation/
 */
public class FindMaxValueOfEquation {

    /**
     * 给你一个数组 points 和一个整数 k 。
     * 数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。
     * 也就是说 points[i] = [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。
     * <p>
     * 请你找出 yi+ yj+ |xi- xj| 的 最大值，其中 |xi- xj|<= k 且 1 <= i < j <= points.length。
     * <p>
     * 题目测试数据保证至少存在一对能够满足 |xi- xj|<= k 的点。
     * <p>
     * 2 <= points.length <= 10^5
     * points[i].length == 2
     * -10^8<= points[i][0], points[i][1] <= 10^8
     * 0 <= k <= 2 * 10^8
     * 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格递增的。
     */
    public int findMaxValueOfEquation(int[][] points, int k) {
        return 0;
    }
}
