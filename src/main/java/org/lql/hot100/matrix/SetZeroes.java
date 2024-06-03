package org.lql.hot100.matrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-24 14:18
 * @description: 73. 矩阵置零 <a href="https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SetZeroes {

    /**
     * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     * <p>
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        // 使用布尔数组标记行和列是否需要置零
        boolean[] rowZero = new boolean[row];
        boolean[] colZero = new boolean[col];

        // 标记需要置零的行和列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        // 置零操作
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetZeroes setZeroes = new SetZeroes();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        System.out.println();
        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
