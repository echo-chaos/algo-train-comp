package org.lql.week06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/10 23:29
 * @description: 120. 三角形最小路径和 https://leetcode-cn.com/problems/triangle/description/
 */
public class MinimumTotal {

    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     * <p>
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     */
    private static final Logger logger = LoggerFactory.getLogger(MinimumTotal.class);

    public int minimumTotal(List<List<Integer>> triangle) {

        return 0;
    }
}
