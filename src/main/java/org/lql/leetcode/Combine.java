package org.lql.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/11 10:59
 * @description: 77. 组合 https://leetcode-cn.com/problems/combinations/
 */
public class Combine {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * 示例 :
     * 输入：n = 4, k = 2
     * 输出：
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * <p>
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     * <p>
     * 提示:
     * 1 <= n <= 20
     * 1 <= k <= n
     */

    int n;
    int k;
    List<Integer> chosen = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1);
        return ans;
    }

    private void recur(int i) {
        // 剪枝：如果已选数量已超过k，或者全部数量不足k，则提前退出程序
        if (chosen.size() > k || chosen.size() + (n - i + 1) < k) {
            return;
        }
        // 递归边界
        if (i == n + 1) {
            ans.add(new ArrayList<Integer>(chosen));
            return;
        }
        // 每层逻辑 nums[i] 选与不选
        recur(i + 1);
        chosen.add(i);
        recur(i + 1);
        // 还原现场
        chosen.remove(chosen.size() - 1);
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> lists = combine.combine(4, 2);
        System.out.println(lists);
    }
}
