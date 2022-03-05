package org.lql.week08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/28 1:25 AM
 * @description: 684. 冗余连接 https://leetcode-cn.com/problems/redundant-connection/
 */
public class FindRedundantConnection {

    /**
     * 树可以看成是一个连通且 无环的无向图。
     * <p>
     * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。
     * 添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。
     * 图的信息记录于长度为 n 的二维数组 edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
     * <p>
     * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组edges中最后出现的边。
     * <p>
     * n == edges.length
     * 3 <= n <= 1000
     * edges[i].length == 2
     * 1 <= ai< bi<= edges.length
     * ai != bi
     * edges 中无重复元素
     * 给定的图是连通的
     */
    private static final Logger logger = LoggerFactory.getLogger(FindRedundantConnection.class);

    int[] fa;

    private int find(int x) {
        if (fa[x] == x) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    private boolean unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[x] = y;
            return true;
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int[] edge : edges) {
            if (!unionSet(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        FindRedundantConnection connection = new FindRedundantConnection();
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] redundantConnection = connection.findRedundantConnection(edges);
        System.out.println(Arrays.toString(redundantConnection));
    }
}
