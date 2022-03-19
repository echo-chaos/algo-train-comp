package org.lql.week08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/28 1:27 AM
 * @description: 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {

    /**
     * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 300
     * grid[i][j] 的值为 '0' 或 '1'
     */
    private static final Logger logger = LoggerFactory.getLogger(NumIslands.class);

    int ans;
    int rowNum;
    int colNum;
    int[] fa;
    int[] rank;

    private int find(int x) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    public int numIslands(char[][] grid) {
        rowNum = grid.length;
        colNum = grid[0].length;
        init(grid);
        return 1;
    }

    public void init(char[][] grid) {
        ans = 0;
        fa = new int[rowNum * colNum];
        rank = new int[rowNum * colNum];
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (grid[i][j] == '1') {
                    fa[i * colNum + j] = i * colNum + j;
                    ++ans;
                }
                rank[i * colNum + j] = 0;
            }
        }
        System.out.println(Arrays.toString(fa));
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        NumIslands islands = new NumIslands();
        int i = islands.numIslands(grid);
    }
}
