package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 19:24
 * @description: 51. N 皇后 <a href="https://leetcode.cn/problems/n-queens/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SolveNQueens {

    private int n;
    private List<Integer> chosen;
    // 结果
    private List<List<Integer>> ans;
    // 每个位置是否被访问过
    private boolean[] used;
    // 对角线线的元素只能出现一次
    private Map<Integer, Boolean> usedPlus;
    // 斜对角线的元素只能出现一次
    private Map<Integer, Boolean> usedMinus;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        chosen = new ArrayList<>();
        ans = new ArrayList<>();
        used = new boolean[n];
        usedPlus = new java.util.HashMap<>();
        usedMinus = new java.util.HashMap<>();
        dfs(0);
        return handleResult();
    }

    public void dfs(int row) {
        if (row == n) {
            ans.add(new ArrayList<>(chosen));
            return;
        }
        // 遍历每一列
        for (int col = 0; col < n; col++) {
            // 剪枝：判断当前位置是否合法
            if (isValid(row, col)) {
                // 添加到结果中、访问标记、对角线标记、斜对角线标记
                chosen.add(col);
                used[col] = true;
                usedPlus.put(row + col, true);
                usedMinus.put(row - col, true);
                dfs(row + 1);
                usedMinus.put(row - col, false);
                usedPlus.put(row + col, false);
                used[col] = false;
                chosen.remove(chosen.size() - 1);
            }
        }
    }

    public boolean isValid(int row, int col) {
        return !used[col] && !usedPlus.getOrDefault(row + col, false) && !usedMinus.getOrDefault(row - col, false);
    }

    public List<List<String>> handleResult() {
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> list : ans) {
            List<String> row = new ArrayList<>();
            for (Integer pos : list) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < n; i++) {
                    sb.append(i == pos ? "Q" : ".");
                }
                row.add(sb.toString());
            }
            result.add(row);
        }
        return result;
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
