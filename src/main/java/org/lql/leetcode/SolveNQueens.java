package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/19 23:53
 * @description: 51. N 皇后 https://leetcode-cn.com/problems/n-queens/
 */
public class SolveNQueens {

    int n;
    List<Integer> p;
    boolean[] used;
    HashSet<Integer> usedPlus;
    HashSet<Integer> usedMinus;
    List<List<Integer>> ans;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        p = new ArrayList<Integer>();
        used = new boolean[n];
        usedPlus = new HashSet<Integer>();
        usedMinus = new HashSet<Integer>();
        ans = new ArrayList<List<Integer>>();
        dfs(0);
        List<List<String>> result = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s.append(".");
        }
        for (List<Integer> p: ans) {
            List<String> pattern = new ArrayList<>();
            for (int row = 0; row < n; row++) {
                StringBuilder str = new StringBuilder(s);
                str.setCharAt(p.get(row), 'Q');
                pattern.add(str.toString());
            }
            result.add(pattern);
        }
        return result;
    }

    private void dfs(int row) {
        if (row == n) {
            ans.add(p);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (!used[col] && !usedPlus.contains(row + col) && !usedMinus.contains(row - col)) {
                p.add(col);
                used[col] = true;
                usedPlus.add(row + col);
                usedMinus.add(row - col);
                dfs(row+1);
                usedMinus.remove(row - col);
                usedPlus.remove(row + col);
                used[col] = false;
                p.remove(p.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> list = solveNQueens.solveNQueens(4);
        System.out.println(list);
    }
}
