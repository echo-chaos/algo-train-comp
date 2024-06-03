package org.lql.hot100.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 22:09
 * @description: 15. 三数之和 <a href="https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class ThreeSum {

    /**
     * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
     * <p>
     * 你返回所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 解释：
     * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
     * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
     * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
     * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
     * 注意，输出的顺序和三元组的顺序并不重要。
     * 示例 2：
     * <p>
     * 输入：nums = [0,1,1]
     * 输出：[]
     * 解释：唯一可能的三元组和不为 0 。
     * 示例 3：
     * <p>
     * 输入：nums = [0,0,0]
     * 输出：[[0,0,0]]
     * 解释：唯一可能的三元组和为 0 。
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 3000
     * -105 <= nums[i] <= 105
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            List<List<Integer>> lists = twoSum(nums, i + 1, -nums[i]);
            for (List<Integer> list : lists) {
                ans.add(Arrays.asList(nums[i], list.get(0), list.get(1)));
            }
        }
        return ans;
    }

    private List<List<Integer>> twoSum(int[] numbers, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int j = numbers.length - 1;
        for (int i = start; i < numbers.length; i++) {
            if (i > start && numbers[i] == numbers[i - 1]) {
                continue;
            }
            if (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (i < j && numbers[i] + numbers[j] == target) {
                ans.add(Arrays.asList(numbers[i], numbers[j]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // [[-1,-1,2],[-1,0,1]]
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // []
        System.out.println(new ThreeSum().threeSum(new int[]{0, 1, 1}));
        // [[0,0,0]]
        System.out.println(new ThreeSum().threeSum(new int[]{0, 0, 0}));
    }

}
