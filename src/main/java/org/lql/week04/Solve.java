package org.lql.week04;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lql
 * @date: 2022/1/23 14:25
 * @description: 130. 被围绕的区域 https://leetcode-cn.com/problems/surrounded-regions/
 */
public class Solve {

    /**
     * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
     * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
     * <p>
     * 输入：board =
     * [
     * ["X","X","X","X"],
     * ["X","O","O","X"],
     * ["X","X","O","X"],
     * ["X","O","X","X"]
     * ]
     * 输出：[
     * ["X","X","X","X"],
     * ["X","X","X","X"],
     * ["X","X","X","X"],
     * ["X","O","X","X"]
     * ]
     */
    private static final Logger logger = LoggerFactory.getLogger(Solve.class);

    int row;
    int col;
    /**
     * 方向数组
     */
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    boolean[][] visit;
    Queue<int[]> queue = new LinkedList<int[]>();

    public void solve(char[][] board) {
        // 矩阵的长宽
        row = board.length;
        col = board[0].length;
        visit = new boolean[row][col];
        // 搜索矩阵并标记O的相邻位置
        bfs(board);
        // 将被标记完成后的矩阵进行处理
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    /**
     * bfs把O相邻的O找到并进行标记
     *
     * @param board 矩阵
     */
    public void bfs(char[][] board) {
        // 矩阵的左右两边扫描
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = '#';
            }
            if (board[i][col - 1] == 'O') {
                queue.offer(new int[]{i, col - 1});
                board[i][col - 1] = '#';
            }
        }
        // 矩阵的上下两边扫描
        for (int i = 1; i < col - 1; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = '#';
            }
            if (board[row - 1][i] == 'O') {
                queue.offer(new int[]{row - 1, i});
                board[row - 1][i] = '#';
            }
        }
        while (!queue.isEmpty()) {
            // 取出队列头部
            int[] peek = queue.poll();
            int x = peek[0];
            int y = peek[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= row || ny < 0 || ny >= col || board[nx][ny] != 'O') {
                    continue;
                }
                queue.offer(new int[]{nx, ny});
                board[nx][ny] = '#';
            }
        }
    }

    public static void main(String[] args) {
        Solve solve = new Solve();
//        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] board = {{'O', 'O', 'O'}, {'O', 'O', 'O'}, {'O', 'O', 'O'}};
        System.out.println("origin：" + Arrays.deepToString(board));
        solve.solve(board);
        System.out.println("result：" + Arrays.deepToString(board));
    }

}
