package org.lql.practice.week04;

import org.lql.common.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: lql
 * @date: 2022/2/13 20:48
 * @description: 200. 岛屿数量 <a href="https://leetcode-cn.com/problems/number-of-islands/">...</a>
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
    // 每个点是否访问过
    private boolean[][] visited;
    // 地图方向数组
    private static int[] dx;
    private static int[] dy;
    // 网格横纵数量
    int m;
    int n;
    public int numIslands(char[][] grid) {
        // 初始化
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, -1, 0, 1};
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 从没访问过的岛屿开始
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
//                    bfs(grid, i, j);
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void bfs(char[][] grid, int sx, int sy) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(sx, sy));
        visited[sx][sy] = true;
        while (!queue.isEmpty()) {
            // 取对头
            Pair<Integer, Integer> poll = queue.poll();
            Integer x = poll.getKey();
            Integer y = poll.getValue();
            // 扩展队头:沿着四个方向扩展
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 点越界
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                // 不为岛屿‘1’
                if (grid[nx][ny] != '1') {
                    continue;
                }
                // 访问过
                if (visited[nx][ny]) {
                    continue;
                }
                // 访问过的放入队列继续扩展
                queue.offer(new Pair<>(nx, ny));
                visited[nx][ny] = true;
            }
        }
    }

    public void dfs(char[][] grid, int sx, int sy) {
        visited[sx][sy] = true;
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            // 点越界
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            // 不为岛屿‘1’
            if (grid[nx][ny] != '1') {
                continue;
            }
            // 访问过
            if (visited[nx][ny]) {
                continue;
            }
            dfs(grid, nx, ny);
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(numIslands.numIslands(grid));
        char[][] grids = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands.numIslands(grids));
    }
}
