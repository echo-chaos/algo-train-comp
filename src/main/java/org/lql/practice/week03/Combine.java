package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/10 23:38
 * @description: 77. 组合 <a href="https://leetcode-cn.com/problems/combinations/">...</a>
 */
public class Combine {

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
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

    private void recur(int i) {
        // 剪枝：如果已选数量已超过k，或者全部数量不足k，则提前退出程序
        if (chosen.size() > k || chosen.size() + (n - i + 1) < k) {
            return;
        }
        // 递归边界
        if (i == n + 1) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // 每层逻辑 i 选与不选
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
