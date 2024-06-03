package org.lql.hot100.graphTheory;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 16:48
 * @description: 200. 岛屿数量 <a href="https://leetcode.cn/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class NumIslands {

    /**
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
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
                    dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    public void dfs(char[][] grid, int sx, int sy) {
        visited[sx][sy] = true;
        for (int i = 0; i < 4; i++) {
            int nx = sx + dx[i];
            int ny = sy + dy[i];
            // 边界判断
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            // 访问过或者不是陆地
            if (visited[nx][ny] || grid[nx][ny] == '0') {
                continue;
            }
            dfs(grid, nx, ny);
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumIslands numIslands = new NumIslands();
        System.out.println(numIslands.numIslands(grid));
    }

}
