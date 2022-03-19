package org.lql.examination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/3/17 20:23
 * @description: 期中-1 18. 四数之和  https://leetcode-cn.com/problems/4sum/
 */
public class MT1FourSum {

    /**
     * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
     * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
     * （若两个四元组元素一一对应，则认为两个四元组重复）：
     * <p>
     * 0 <= a, b, c, d< n
     * a、b、c 和 d 互不相同
     * nums[a] + nums[b] + nums[c] + nums[d] == target
     * 你可以按 任意顺序 返回答案 。
     * <p>
     * 1 <= nums.length <= 200
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     */

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 边界判断
        if (nums.length < 4) {
            return ans;
        }
        // 排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = threeSum(nums, i + 1, target - nums[i]);
            for (List<Integer> res : lists) {
                ans.add(Arrays.asList(nums[i], res.get(0), res.get(1), res.get(2)));
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        // 边界判断
        if (nums.length < 3) {
            return res;
        }
        // 排序
        Arrays.sort(nums);
        // 数组长度
        int n = nums.length;
        for (int i = start; i < n; i++) {
            int a = nums[i];
            // 起始数字不满足直接返回
//            if (a > target) {
//                return res;
//            }
            // 前后两个数字相同继续下一层
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 当前位置之后的左右指针
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int temp = a + nums[left] + nums[right];
                if (temp > target) {
                    right--;
                } else if (temp < target) {
                    left++;
                } else {
                    res.add(Arrays.asList(a, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left++;
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MT1FourSum fourSum = new MT1FourSum();
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        int target = -11;
        List<List<Integer>> list = fourSum.fourSum(nums, target);
        // [[-5,-4,-3,1]]
        System.out.println(list);
    }
}
