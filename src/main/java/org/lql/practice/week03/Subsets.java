package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/10 22:41
 * @description: 78. 子集 <a href="https://leetcode-cn.com/problems/subsets/">...</a>
 */
public class Subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     */

    // 可以选择的数组元素数量
    int n;
    // 被选择的数组元素
    List<Integer> chosen = new ArrayList<>();
    // 结果
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        // 初始化元素总数
        n = nums.length;
        // 从第0个元素开始选择
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int i) {
        // 递归边界：选择到了最后一个元素
        if (i == n) {
            // 记录答案
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // 每层逻辑 nums[i] 选与不选
        recur(nums, i + 1);
        chosen.add(nums[i]);
        recur(nums, i + 1);
        // 还原现场：对称还原
        chosen.remove(chosen.size() - 1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets.subsets(nums);
        System.out.println(lists);
    }
}
