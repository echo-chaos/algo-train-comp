package org.lql.practice.week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/13 20:47
 * @description: 51. N 皇后 <a href="https://leetcode-cn.com/problems/n-queens/">...</a>
 */
public class SolveNQueens {

    /**
     * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
     * <p>
     * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 1 <= n <= 9
     */
    private int n;
    private List<Integer> p;
    // 结果
    private List<List<Integer>> ans;
    // 每个位置是否被访问过
    private boolean[] used;
    // 对角线伤的元素只能出现一次
    private Map<Integer, Boolean> usedPlus;
    // 斜对角线的元素只能出现一次
    private Map<Integer, Boolean> usedMinus;


    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        used = new boolean[n];
        usedPlus = new HashMap<>();
        usedMinus = new HashMap<>();
        p = new ArrayList<>();
        ans = new ArrayList<>();
        dfs(0);
        return constructResult();
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(p));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!used[col] && !usedPlus.getOrDefault(row + col, false) && !usedMinus.getOrDefault(row - col, false)) {
                p.add(col);
                used[col] = true;
                usedPlus.put(row + col, true);
                usedMinus.put(row - col, true);
                dfs(row + 1);
                usedMinus.put(row - col, false);
                usedPlus.put(row + col, false);
                used[col] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    private List<List<String>> constructResult() {
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> p : ans) {
            List<String> pattern = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder str = new StringBuilder();
                for (int col = 0; col < n; col++) {
                    str.append(p.get(row) == col ? 'Q' : '.');
                }
                pattern.add(str.toString());
            }
            result.add(pattern);
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
