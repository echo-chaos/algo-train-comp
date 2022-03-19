package org.lql.practice.week10;

/**
 * @author: lql
 * @date: 2022/3/13 21:09
 * @description: 1851. 包含每个查询的最小区间 https://leetcode-cn.com/problems/minimum-interval-to-include-each-query/
 */
public class MinInterval {

    /**
     * 给你一个二维整数数组 intervals ，
     * 其中 intervals[i] = [lefti, righti] 表示第 i 个区间开始于 lefti 、结束于 righti（包含两侧取值，闭区间）。
     * 区间的 长度 定义为区间中包含的整数数目，更正式地表达是 righti - lefti + 1 。
     * <p>
     * 再给你一个整数数组 queries 。
     * 第 j 个查询的答案是满足lefti <= queries[j] <= righti 的 长度最小区间 i 的长度 。
     * 如果不存在这样的区间，那么答案是 -1 。
     * <p>
     * 以数组形式返回对应查询的所有答案。
     * <p>
     * 1 <= intervals.length <= 105
     * 1 <= queries.length <= 105
     * queries[i].length == 2
     * 1 <= lefti <= righti <= 107
     * 1 <= queries[j] <= 107
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        return new int[]{};
    }
}
