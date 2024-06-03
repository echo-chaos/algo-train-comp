package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 14:24
 * @description: 78. 子集 <a href="https://leetcode.cn/problems/subsets/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Subsets {

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 10
     * -10 <= nums[i] <= 10
     * nums 中的所有元素 互不相同
     */
    int n;
    List<Integer> chosen = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        recur(nums, 0);
        return ans;
    }

    public void recur(int[] nums, int pos) {
        if (pos == n) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // 每层相似逻辑：nums[i]选或不选
        // 1、不选择元素往下一个分支走
        recur(nums, pos + 1);
        // 2、选择元素往下一个分支走，结束之后需要还原选择的内容
        chosen.add(nums[pos]);
        recur(nums, pos + 1);
        chosen.remove(chosen.size() - 1);
    }
}
