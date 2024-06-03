package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 14:42
 * @description: 77. 组合 <a href="https://leetcode.cn/problems/combinations/description/">...</a>
 **/
public class Combine {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
     * <p>
     * 你可以按 任何顺序 返回答案。
     * <p>
     * 示例 1：
     * <p>
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
     * 示例 2：
     * <p>
     * 输入：n = 1, k = 1
     * 输出：[[1]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 20
     * 1 <= k <= n
     */
    int n;
    int k;
    List<Integer> chosen = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        recur(1);
        return ans;
    }

    public void recur(int pos) {
        // 剪枝：提前判断一些不可能的情况，提前退出
        if (chosen.size() > k || chosen.size() + (n - pos + 1) < k) {
            return;
        }
        // 递归边界：递归边界，递归到底了，说明已经找到了一个组合
        if (pos == n + 1) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // 每层相似逻辑
        recur(pos + 1);
        chosen.add(pos);
        recur(pos + 1);
        chosen.remove(chosen.size() - 1);
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        System.out.println(combine.combine(4, 2));
    }
}
