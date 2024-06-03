package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 14:03
 * @description: 46. 全排列 <a href="https://leetcode.cn/problems/permutations/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Permute {

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * <p>
     * 示例 3：
     * <p>
     * 输入：nums = [1]
     * 输出：[[1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 6
     * -10 <= nums[i] <= 10
     * nums 中的所有整数 互不相同
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

    public void recur(int[] nums, int pos) {
        // 递归终止条件：当前位置为n，说明已经找到了一个排列，将其加入答案中
        if (pos == n) {
            ans.add(new ArrayList<>(range));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                // 将当前数字加入排列中，并标记为已使用
                range.add(nums[i]);
                used[i] = true;
                // 递归调用下一个位置：选择一个未使用的数字
                recur(nums, pos + 1);
                // 恢复现场，将当前数字从排列中移除，并标记为未使用
                used[i] = false;
                range.remove(range.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[]{1, 2, 3}));
    }
}
