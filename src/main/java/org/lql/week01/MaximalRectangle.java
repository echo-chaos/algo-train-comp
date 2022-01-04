package org.lql.week01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/1/2 13:36
 * @description: 85. 最大矩形 https://leetcode-cn.com/problems/maximal-rectangle/
 */
public class MaximalRectangle {

    /*
     * <p>实例1：</p>
     * 输入：matrix =
     * [
     * ["1","0","1","0","0"],
     * ["1","0","1","1","1"],
     * ["1","1","1","1","1"],
     * ["1","0","0","1","0"]
     * ]
     * 输出：6
     *
     * <p>实例2：</p>
     * 输入：matrix = []
     * 输出：0
     *
     * <p>提示：</p>
     * <li>rows == matrix.length</li>
     * <li>cols == matrix[0].length</li>
     * <li>1 <= row, cols <= 200</li>
     * <li>matrix[i][j] 为 '0' 或 '1'</li>
     */

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     *
     * @param matrix mat
     * @return res
     */
    public int maximalRectangle(char[][] matrix) {
        // 边界
        if (matrix == null) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        // row[0]-row[i]之间柱子高度
        int[][] arr = new int[row][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && matrix[i][j] == '1') {
                    arr[i][j] = 1;
                } else if (i == 0 && matrix[i][j] == '0') {
                    arr[i][j] = 0;
                } else if (i > 0 && matrix[i][j] == '1') {
                    arr[i][j] = arr[i - 1][j] + 1;
                } else if (i > 0 && matrix[i][j] == '0') {
                    arr[i][j] = 0;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
        //单调栈求局部最大值
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int index = 0; index < col + 1; index++) {
                while (!stack.isEmpty() && arr[i][stack.peek()] >= arr[i][index]) {
                    Integer pop = stack.pop();
                    int height = arr[i][pop];
                    if (!stack.isEmpty()) {
                        ans = Math.max(ans, height * (index - stack.peek() - 1));
                    } else {
                        ans = Math.max(ans, height * index);
                    }
                }
                stack.push(index);
            }
            // ！！！因为使用的是二维数组，所以在一行单调栈计算完之后需要进行清空操作
            stack.clear();
        }
        return ans;
    }

    public static void main(String[] args) {
        MaximalRectangle rectangle = new MaximalRectangle();
//        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        char[][] matrix = {{'1', '0'}, {'1', '0'}};
        int maximalRectangle = rectangle.maximalRectangle(matrix);
        System.out.println(maximalRectangle);
    }
}
