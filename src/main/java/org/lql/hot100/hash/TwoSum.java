package org.lql.hot100.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 20:43
 * @description: 两数之和 <a href="https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class TwoSum {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     * <p>
     * 你可以按任意顺序返回答案。
     */
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
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum.twoSum(nums, 9)));
    }
}
