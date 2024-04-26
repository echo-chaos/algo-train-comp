package org.lql.practice.week04;

/**
 * @author: lql
 * @date: 2022/2/13 20:51
 * @description: 329. 矩阵中的最长递增路径 <a href="https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/">...</a>
 */
public class LongestIncreasingPathDFS {


    /**
     * 给定一个m x n 整数矩阵matrix ，找出其中 最长递增路径 的长度。
     * <p>
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。
     * 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 200
     * 0 <= matrix[i][j] <= 231 - 1
     */

    private int m;
    private int n;
    // 每个点算过的最长长度
    private int[][] dist;
    private int[] dx;
    private int[] dy;
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        // 初始化
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        dist = new int[m][n];
        // 方向数组
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, 1, 0, -1};
        int ans = 0;
        // 逐个遍历进行dfs
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        return ans;
    }

    private int dfs(int x, int y) {
        // 记忆化：如果当前位置处理过，直接返回，避免多次处理
        if (dist[x][y] != 0) {
            return dist[x][y];
        }
        // 初始位置：1
        dist[x][y] = 1;
        // 根据四个方向处理
        for (int k = 0; k < 4; k++) {
            // 根据方向数组计算下一个点的位置
            int nx = x + dx[k];
            int ny = y + dy[k];
            // 点的位置合法且递增
            if (valid(nx, ny) && matrix[nx][ny] > matrix[x][y]) {
                // 更新最远位置
                dist[x][y] = Math.max(dist[x][y], dfs(nx, ny) + 1);
            }
        }
        return dist[x][y];
    }

    /**
     * 判断当前点是否合法
     */
    private boolean valid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }


    public static void main(String[] args) {
        LongestIncreasingPathDFS longestIncreasingPath = new LongestIncreasingPathDFS();
        // 4
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        }));
        // 4
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        }));
        // 1
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{
                {1}
        }));
    }
}
