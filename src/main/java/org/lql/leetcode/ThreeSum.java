package org.lql.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/8 21:09
 * @description: 15. 三数之和  https://leetcode-cn.com/problems/3sum/
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //边界
        if (nums.length < 3) {
            return result;
        }
        //排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (a > 0) {
                return result;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (a + nums[l] + nums[r] > 0) {
                    r--;
                } else if (a + nums[l] + nums[r] < 0) {
                    l++;
                } else {
                    result.add(Arrays.asList(a, nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum.threeSum(nums);
        System.out.println(lists);
    }
}
