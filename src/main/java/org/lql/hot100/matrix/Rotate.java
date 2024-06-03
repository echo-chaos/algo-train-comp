package org.lql.hot100.matrix;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-05-24 15:38
 * @description: 48. 旋转图像 <a href="https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Rotate {

    /**
     * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * <p>
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * 示例 2：
     * <p>
     * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     * <p>
     * 提示：
     * <p>
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 转置矩阵
        // 将matrix[i][j]与matrix[j][i]互换，实现行与列的交换
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        print(matrix);

        // 反转每一行：
        // 将matrix[i][j]与matrix[i][n-1-j]互换，实现每一行的前半部分与后半部分的反转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
        print(matrix);
    }

    public static void print(int[][] matrix) {
        System.out.println();
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        print(matrix);
        new Rotate().rotate(matrix);
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        print(matrix);
        new Rotate().rotate(matrix);
    }
}
