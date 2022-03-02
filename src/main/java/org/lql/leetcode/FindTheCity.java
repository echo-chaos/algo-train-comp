package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/28 1:19 AM
 * @description: 1334. 阈值距离内邻居最少的城市 https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class FindTheCity {

    /**
     * 有 n个城市，按从 0 到 n-1编号。给你一个边数组edges，
     * 其中 edges[i] = [fromi, toi, weighti]代表fromi和toi两个城市之间的双向加权边，距离阈值是一个整数distanceThreshold。
     * <p>
     * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为distanceThreshold的城市。如果有多个这样的城市，则返回编号最大的城市。
     * <p>
     * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
     * <p>
     * 2 <= n <= 100
     * 1 <= edges.length <= n * (n - 1) / 2
     * edges[i].length == 3
     * 0 <= fromi < toi < n
     * 1 <= weighti,distanceThreshold <= 10^4
     * 所有 (fromi, toi)都是不同的。
     */
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] d = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = 1_000_000_000;
            }
        }
        for (int i = 0; i < n; i++) {
            d[i][i] = 0;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int z = edge[2];
            d[x][y] = d[y][x] = z;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    d[j][k] = Math.min(d[j][k], d[j][i] + d[i][k]);
                }
            }
        }
        int minNeighbor = 1_000_000_000;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int neighbor = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && d[i][j] <= distanceThreshold) {
                    neighbor++;
                }
            }
            if (neighbor < minNeighbor || neighbor == minNeighbor && i > ans) {
                minNeighbor = neighbor;
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindTheCity city = new FindTheCity();
        int n = 4;
        int[][] edges = {{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}};
        int distanceThreshold = 4;
        int theCity = city.findTheCity(n, edges, distanceThreshold);
        System.out.println(theCity);
    }
}
