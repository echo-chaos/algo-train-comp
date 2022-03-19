package org.lql.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/3/8 01:49
 * @description: 36. 有效的数独 https://leetcode-cn.com/problems/valid-sudoku/
 */
public class IsValidSudoku {

    /**
     * 请你判断一个9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
     * <p>
     * 数字1-9在每一行只能出现一次。
     * 数字1-9在每一列只能出现一次。
     * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
     * <p>
     * 注意：
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 空白格用'.'表示。
     * <p>
     * board.length == 9
     * board[i].length == 9
     * board[i][j] 是一位数字（1-9）或者 '.'
     */
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Character>> row = new ArrayList<>(9);
        List<HashSet<Character>> col = new ArrayList<>(9);
        List<HashSet<Character>> box = new ArrayList<>(9);
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            box.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char digit = board[i][j];
                if (digit == '.') {
                    continue;
                }
                if (row.get(i).contains(digit)) {
                    return false;
                } else {
                    row.get(i).add(digit);
                }
                if (col.get(j).contains(digit)) {
                    return false;
                } else {
                    col.get(j).add(digit);
                }
                int z = (i / 3) * 3 + (j / 3);
                if (box.get(z).contains(digit)) {
                    return false;
                } else {
                    box.get(z).add(digit);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                };
        IsValidSudoku sudoku = new IsValidSudoku();
        boolean validSudoku = sudoku.isValidSudoku(board);
        System.out.println(validSudoku);
    }
}

