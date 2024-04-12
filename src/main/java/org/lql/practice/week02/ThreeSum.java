package org.lql.practice.week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/3 22:40
 * @description: 15. 三数之和 <a href="https://leetcode-cn.com/problems/3sum/">...</a>
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // 数组排序
        Arrays.sort(nums);
        // 结果
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果相邻两个数组元素一样，则跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 扣除当前数组元素的值为目标的两数之和计算
            List<List<Integer>> lists = twoSum(nums, i + 1, -nums[i]);
            // 将符合条件的结果加入答案
            for (List<Integer> list : lists) {
                ans.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
            }
        }
        return ans;
    }

    /***
     * 计算两数之和
     *
     * @param numbers 数组
     * @param start 开始位置
     * @param target 目标数字
     * @return: 符合条件的两数之和结果
     * @author: liangqinglong
     * @date: 2024-04-12 23:25
     **/

    private List<List<Integer>> twoSum(int[] numbers, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int j = numbers.length - 1;
        for (int i = start; i < numbers.length; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) {
                continue;
            }
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (i < j && numbers[i] + numbers[j] == target) {
                ans.add(Arrays.asList(numbers[i], numbers[j]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);
    }
}
