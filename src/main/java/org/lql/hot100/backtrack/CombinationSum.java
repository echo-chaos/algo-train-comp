package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 15:22
 * @description: 39. 组合总和 <a href="https://leetcode.cn/problems/combination-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class CombinationSum {

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     * <p>
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * <p>
     * 示例 1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * <p>
     * 示例 2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * <p>
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= candidates.length <= 30
     * 2 <= candidates[i] <= 40
     * candidates 的所有元素 互不相同
     * 1 <= target <= 40
     */

    List<Integer> chosen = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int[] candidates;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        recur(0, target);
        return ans;
    }

    public void recur(int pos, int target) {
        // 递归边界：剩余目标为0，说明已经找到一个组合
        if (target == 0) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // 遍历候选数组
        for (int i = pos; i < candidates.length; i++) {
            // 剪枝：如果候选数大于剩余目标，则跳过
            if (candidates[i] > target) {
                continue;
            }
            // 递归：将当前候选数加入组合，并递归调用下一层
            chosen.add(candidates[i]);
            recur(i, target - candidates[i]);
            chosen.remove(chosen.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum.combinationSum(candidates, target));
    }
}
