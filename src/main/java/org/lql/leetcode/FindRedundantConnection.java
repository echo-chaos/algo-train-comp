package org.lql.leetcode;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/17 22:14
 * @description: 684. 冗余连接 https://leetcode-cn.com/problems/redundant-connection/description/
 */
public class FindRedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (find(parent, x) != find(parent, y)) {
                union(parent, x, y);
            } else {
                return edge;
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }

    public static void main(String[] args) {
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantConnection = findRedundantConnection.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }
}
