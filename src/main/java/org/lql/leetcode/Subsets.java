package org.lql.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/10 14:23
 * @description: 78. 子集 https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 边界
        if (nums.length == 0 || nums.length > 10) {
            return null;
        }
        // 结果集
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 初始空集
        ans.add(new ArrayList<>());
        // 遍历nums
        for (int num : nums) {
            // 将当前的结果重新放入
            int pre = ans.size();
            System.out.println("ans-num : " + ans + " <> " + num);
            for (int j = 0; j < pre; j++) {
                List<Integer> temp = new ArrayList<>(ans.get(j).size() + 1);
                temp.addAll(ans.get(j));
                temp.add(num);
                System.out.println("temp-j : " + temp + " <> " + j);
                ans.add(temp);
                System.out.println();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets.subsets(nums);
        System.out.println(lists);
    }

}
