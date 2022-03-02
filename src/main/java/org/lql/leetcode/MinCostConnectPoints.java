package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/3/1 1:27 AM
 * @description: 1584. 连接所有点的最小费用 https://leetcode-cn.com/problems/min-cost-to-connect-all-points/
 */
public class MinCostConnectPoints {
    /**
     * 给你一个points数组，表示 2D 平面上的一些点，其中points[i] = [xi, yi]。
     * <p>
     * 连接点[xi, yi] 和点[xj, yj]的费用为它们之间的 曼哈顿距离：|xi - xj| + |yi - yj|，其中|val|表示val的绝对值。
     * <p>
     * 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有一条简单路径时，才认为所有点都已连接。
     * <p>
     * 1 <= points.length <= 1000
     * -106 <= xi, yi <= 106
     * 所有点 (xi, yi) 两两不同。
     */
    private int[] fa;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new int[]{i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])});
            }
        }
        edges.sort(Comparator.comparingInt(item -> item[2]));
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        int ans = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            x = find(x);
            y = find(y);
            if (x != y) {
                ans += z;
                fa[x] = y;
            }
        }
        return ans;
    }

    private int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    public static void main(String[] args) {
        MinCostConnectPoints minCostConnectPoints = new MinCostConnectPoints();
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        int i = minCostConnectPoints.minCostConnectPoints(points);
        System.out.println(i);
    }
}
