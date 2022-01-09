package org.lql.practice.week02;

/**
 * @author: lql
 * @date: 2022/1/3 22:37
 * @description: 304. 二维区域和检索 - 矩阵不可变 https://leetcode-cn.com/problems/range-sum-query-2d-immutable/
 */
public class NumMatrix {
    int[][] sum;

    /**
     * 二维前缀和
     *
     * @param matrix 二维矩阵
     */
    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        sum = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    /**
     * 二维矩阵和
     *
     * @param row1 1
     * @param col1 2
     * @param row2 3
     * @param col2 4
     * @return ans
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        return sum[row2][col2] - sum[row1 - 1][col2] - sum[row2][col1 - 1] + sum[row1 - 1][col1 - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int sumRegion = 0;
        sumRegion = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(sumRegion);
        sumRegion = numMatrix.sumRegion(1, 1, 2, 2);
        System.out.println(sumRegion);
        sumRegion = numMatrix.sumRegion(1, 2, 2, 4);
        System.out.println(sumRegion);
    }
}
