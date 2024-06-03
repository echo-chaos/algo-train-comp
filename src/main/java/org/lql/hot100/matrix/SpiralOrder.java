package org.lql.hot100.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-24 15:18
 * @description: 54. 螺旋矩阵 <a href="https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SpiralOrder {

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * <p>
     * 示例 1：
     * <p>
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     * <p>
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        // 矩阵行列数
        int row = matrix.length;
        int col = matrix[0].length;
        // 矩阵左、右、上、下边界
        int left = 0, right = col - 1, top = 0, bottom = row - 1;
        while (left <= right && top <= bottom) {
            // 遍历上边界，更新上边界
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            // 遍历右边界，更新右边界
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            // 上边界不超过下边界，遍历下边界，更新下边界
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // 左边界不超过右边界，遍历左边界，更新左边界
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}
