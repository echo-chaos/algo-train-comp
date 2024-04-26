package org.lql.practice.week04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: lql
 * @date: 2022/2/13 20:51
 * @description: 329. 矩阵中的最长递增路径 <a href="https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/">...</a>
 */
public class LongestIncreasingPath {


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
    private List<List<Integer>> to;
    private int[] degree;
    private int[] dist;

    public int longestIncreasingPath(int[][] matrix) {
        // 初始化
        m = matrix.length;
        n = matrix[0].length;
        // 出边数组
        to = new ArrayList<>();
        for (int i = 0; i < m * n; i++) {
            to.add(new ArrayList<>());
        }
        // 节点的度
        degree = new int[m * n];
        // 到达点的最远距离记录
        dist = new int[m * n];
        // 方向数组
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    // 根据方向数组计算下一个点的位置
                    int ni = i + dx[k];
                    int nj = j + dy[k];
                    // 判断点位置是否合法 && 满足递增关系
                    if (valid(ni, nj) && matrix[ni][nj] > matrix[i][j]) {
                        // 进行出边数组加边操作
                        addEdge(hashCalc(i, j), hashCalc(ni, nj));
                    }
                }
            }
        }
        // 广搜队列
        Queue<Integer> queue = new LinkedList<>();
        // 寻找入度为0的点，即最小的数作为递增路径的起点
        for (int i = 0; i < m * n; i++) {
            if (degree[i] == 0) {
                // 将点放入队列
                queue.offer(i);
                // 设置初始长度
                dist[i] = 1;
            }
        }
        // 广搜处理
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            for (Integer y : to.get(x)) {
                // 入度减1
                degree[y]--;
                // 更新最远距离
                dist[y] = Math.max(dist[y], dist[x] + 1);
                // 如果入度为0，即当前点的所有情况处理完毕，将当前点放入队列
                if (degree[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        // 处理结果
        int ans = 0;
        for (int i = 0; i < m * n; i++) {
            ans = Math.max(dist[i], ans);
        }
        return ans;
    }

    /**
     * 判断当前点是否合法
     */
    private boolean valid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    /**
     * 简单的哈希计算：将二维数组表格转换为一维
     */
    private int hashCalc(int i, int j) {
        return i * n + j;
    }

    /**
     * 出边数组加边 u -> v
     */
    private void addEdge(int u, int v) {
        // 入度增加
        degree[v]++;
        // u-v边关系
        to.get(u).add(v);
    }

    public static void main(String[] args) {
        LongestIncreasingPath longestIncreasingPath = new LongestIncreasingPath();
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
        System.out.println(longestIncreasingPath.longestIncreasingPath(new int[][]{
                {0}, {1}, {5}, {5}
        }));
    }
}
