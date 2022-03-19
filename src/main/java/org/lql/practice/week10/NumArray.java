package org.lql.practice.week10;

/**
 * @author: lql
 * @date: 2022/3/13 20:52
 * @description: 307. 区域和检索 - 数组可修改 https://leetcode-cn.com/problems/range-sum-query-mutable/
 */
public class NumArray {

    /**
     * 给你一个数组 nums ，请你完成两类查询。
     * <p>
     * 其中一类查询要求 更新 数组nums下标对应的值
     * 另一类查询要求返回数组nums中索引left和索引right之间（包含）的nums元素的 和，其中left <= right
     * 实现 NumArray 类：
     * <p>
     * NumArray(int[] nums) 用整数数组 nums 初始化对象
     * void update(int index, int val) 将 nums[index] 的值 更新 为 val
     * int sumRange(int left, int right) 返回数组nums中索引left和索引right之间（包含）的nums元素的
     * 和（即，nums[left] + nums[left + 1], ..., nums[right]）
     * <p>
     * 1 <= nums.length <= 3 *104
     * -100 <= nums[i] <= 100
     * 0 <= index < nums.length
     * -100 <= val <= 100
     * 0 <= left <= right < nums.length
     * 调用 pdate 和 sumRange 方法次数不大于3 * 104
     */
    public NumArray(int[] nums) {

    }

    public void update(int index, int val) {

    }

    public int sumRange(int left, int right) {
        return 1;
    }
}
