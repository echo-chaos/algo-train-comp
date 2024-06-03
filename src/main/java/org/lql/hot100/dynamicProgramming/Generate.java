package org.lql.hot100.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 11:31
 * @description: 118. 杨辉三角 <a href="https://leetcode.cn/problems/pascals-triangle/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Generate {

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * <p>
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例 1:
     * <p>
     * 输入: numRows = 5
     * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
     * <p>
     * 示例 2:
     * <p>
     * 输入: numRows = 1
     * 输出: [[1]]
     * <p>
     * 提示:
     * <p>
     * 1 <= numRows <= 30
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(row);
        }
        return res;
    }

    public static void main(String[] args) {
        Generate generate = new Generate();
        List<List<Integer>> res = generate.generate(5);
        System.out.println(res);
    }
}
