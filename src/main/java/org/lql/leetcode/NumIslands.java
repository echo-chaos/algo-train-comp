package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/20 22:57
 * @description: 200. 岛屿数量 https://leetcode-cn.com/problems/number-of-islands/
 */
public class NumIslands {

    int m;
    int n;
    boolean[][] visited;

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    bfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    private void bfs(char[][] grid, int sx, int sy) {
        Queue<Map<Integer, Integer>> q = new ArrayDeque<>();
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sx, sy);
        q.add(map);
        visited[sx][sy] = true;
        while (!q.isEmpty()) {
            Map<Integer, Integer> peek = q.peek();
            Iterator<Map.Entry<Integer, Integer>> entries = peek.entrySet().iterator();
            Map.Entry<Integer, Integer> next = entries.next();
            Integer x = next.getKey();
            Integer y = next.getValue();
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int length = grid.length;
                int height = grid[0].length;
                if (grid[nx][ny] != '1') {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(nx, ny);
                q.add(temp);
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        int i = numIslands.numIslands(grid);
        System.out.println(i);
    }
}
