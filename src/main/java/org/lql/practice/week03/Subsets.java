package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/10 22:41
 * @description: 78. 子集 https://leetcode-cn.com/problems/subsets/
 */
public class Subsets {

    int n;
    List<Integer> chosen = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int i) {
        // 递归边界
        if (i == n) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        // 每层逻辑 nums[i] 选与不选
        recur(nums, i + 1);
        chosen.add(nums[i]);
        recur(nums, i + 1);
        // 还原现场
        chosen.remove(chosen.size() - 1);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = subsets.subsets(nums);
        System.out.println(lists);
    }
}
