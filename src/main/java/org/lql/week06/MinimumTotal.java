package org.lql.week06;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
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
     * 每一步只能移动到下一行中相邻的结点上。
     * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
     * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     * <p>
     * 1 <= triangle.length <= 200
     * triangle[0].length == 1
     * triangle[i].length == triangle[i - 1].length + 1
     * -104 <= triangle[i][j] <= 104
     */
    private static final Logger logger = LoggerFactory.getLogger(MinimumTotal.class);

    /**
     * 2
     * 3 4
     * 6 5 7
     * 4 1 8 3
     * <p>
     * a
     * b c
     * d e f
     * g h i j
     * k l m n o
     * p q r s t u
     * v w x y z ！ @
     * # ¥ $ % ^ &  * +
     * <p>
     * i,j -> i-1,j / i-1,j-1
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int n = triangle.size();
        // 每个位置的路径和
        int[][] dp = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            // 第i行的起始位置路径和
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; j++) {
                // 第i行每个位置的最小路径和
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
            }
            // 第i行第i列的路径和
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        Arrays.sort(dp[n - 1]);
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        MinimumTotal minimumTotal = new MinimumTotal();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int i = minimumTotal.minimumTotal(triangle);
        System.out.println(i);
    }
}
