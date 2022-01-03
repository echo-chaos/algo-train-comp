package org.lql.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 16:51
 * @description: 1. 两数之和 https://leetcode-cn.com/problems/two-sum/description/
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(nums));
        nums = twoSum.twoSum(nums, target);
        System.out.println(Arrays.toString(nums));
    }
}
