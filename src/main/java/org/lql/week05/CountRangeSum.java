package org.lql.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/7 23:20
 * @description: 327. 区间和的个数 https://leetcode-cn.com/problems/count-of-range-sum/
 */
public class CountRangeSum {

    /**
     * 给你一个整数数组nums 以及两个整数lower 和 upper 。
     * 求数组中，值位于范围 [lower, upper] （包含lower和upper）之内的 区间和的个数 。
     * <p>
     * 区间和S(i, j)表示在nums中，位置从i到j的元素之和，包含i和j(i ≤ j)。
     * <p>
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * -105 <= lower <= upper <= 105
     * 题目数据保证答案是一个 32 位 的整数
     */
    private static final Logger logger = LoggerFactory.getLogger(CountRangeSum.class);

    public int countRangeSum(int[] nums, int lower, int upper) {

        return 0;
    }

    public static void main(String[] args) {
        CountRangeSum countRangeSum = new CountRangeSum();
        int[] nums = {-2, 5, -1};
        int lower = -2;
        int upper = 2;
        int i = countRangeSum.countRangeSum(nums, lower, upper);
        System.out.println(i);
    }
}
