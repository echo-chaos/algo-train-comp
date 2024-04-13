package org.lql.week02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:43
 * @description: 560. 和为 K 的子数组 <a href="https://leetcode-cn.com/problems/subarray-sum-equals-k/">...</a>
 */
public class SubarraySum {

    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
     *
     * <P>示例：</P>
     * <li>输入：nums = [1,1,1], k = 2</li>
     * <li>输出：2</li>
     *
     * <li>输入：nums = [1,2,3], k = 3</li>
     * <li>输出：2</li>
     *
     * <p>提示: </p>
     * <li>1 <= nums.length <= 2 * 104</li>
     * <li>-1000 <= nums[i] <= 1000</li>
     * <li>-107 <= k <= 107</li>
     * <li></li>
     */
    private static final Logger logger = LoggerFactory.getLogger(SubarraySum.class);

    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        // 连续次数->数组元素个数、前缀和
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            // pre[i] = pre[i-1] + nums[i]
            // k -> (j~i)
            // k -> pre[i] - pre[j-1]
            // pre[j-1] = pre[i] - k
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public int subarraySumA(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int target = sum[i] - k;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        SubarraySum sum = new SubarraySum();
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(sum.subarraySum(nums, k));
        System.out.println(sum.subarraySumA(nums, k));
    }
}
