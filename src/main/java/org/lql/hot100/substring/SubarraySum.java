package org.lql.hot100.substring;

import java.util.HashMap;

/**
 * @author: liangqinglong
 * @date: 2024-05-22 14:52
 * @description: 560. 和为 K 的子数组 <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SubarraySum {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
     * <p>
     * 子数组是数组中元素的连续非空序列。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1], k = 2
     * 输出：2
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3], k = 3
     * 输出：2
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 2 * 104
     * -1000 <= nums[i] <= 1000
     * -107 <= k <= 107
     */
    public int subarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        // 前缀和
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 遍历前缀和数组
        for (int item : sum) {
            int targetSum = item - k;
            // 如果目标和存在于哈希表中，说明存在和为目标和的连续子数组
            if (map.containsKey(targetSum)) {
                count += map.get(targetSum);
            }
            // 更新当前前缀和的位置信息
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        // 2
        System.out.println(subarraySum.subarraySum(new int[]{1, 1, 1}, 2));
        // 2
        System.out.println(subarraySum.subarraySum(new int[]{1, 2, 3}, 3));
        // 3
        System.out.println(subarraySum.subarraySum(new int[]{1, -1, 0}, 0));
    }
}
