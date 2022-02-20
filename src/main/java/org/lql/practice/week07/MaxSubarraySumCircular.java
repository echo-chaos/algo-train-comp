package org.lql.practice.week07;

/**
 * @author: lql
 * @date: 2022/2/20 10:35 PM
 * @description: 918. 环形子数组的最大和 https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
 */
public class MaxSubarraySumCircular {

    /**
     * 给定一个长度为 n 的环形整数数组nums，返回nums的非空 子数组 的最大可能和。
     * <p>
     * 环形数组意味着数组的末端将会与开头相连呈环状。形式上，
     * nums[i] 的下一个元素是 nums[(i + 1) % n] ，
     * nums[i]的前一个元素是 nums[(i - 1 + n) % n] 。
     * <p>
     * 子数组 最多只能包含固定缓冲区nums中的每个元素一次。形式上，
     * 对于子数组nums[i], nums[i + 1], ..., nums[j]，不存在i <= k1, k2 <= j其中k1 % n == k2 % n。
     * <p>
     * n == nums.length
     * 1 <= n <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104​​​​​​​
     */
    public int maxSubarraySumCircular(int[] nums) {
        return 0;
    }
}
