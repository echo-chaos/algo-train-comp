package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/10 23:49
 * @description: 46. 全排列 <a href="https://leetcode-cn.com/problems/permutations/">...</a>
 */
public class Permute {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     */

    int n;
    boolean[] used;
    List<Integer> range = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        used = new boolean[n];
        recur(nums, 0);
        return ans;
    }

    private void recur(int[] nums, int pos) {
        // 递归边界
        if (pos == n) {
            ans.add(new ArrayList<>(range));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                range.add(nums[i]);
                used[i] = true;
                recur(nums, pos + 1);
                used[i] = false;
                range.remove(range.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = permute.permute(nums);
        System.out.println(lists);
    }
}
