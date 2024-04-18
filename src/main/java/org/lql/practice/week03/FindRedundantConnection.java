package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/13 20:36
 * @description: 684. 冗余连接 <a href="https://leetcode-cn.com/problems/redundant-connection/description/">...</a>
 */
public class FindRedundantConnection {

    /**
     * 树可以看成是一个连通且 无环的无向图。
     * <p>
     * 给定往一棵n 个节点 (节点值1～n) 的树中添加一条边后的图。
     * 添加的边的两个顶点包含在 1 到 n中间，且这条附加的边不属于树中已存在的边。
     * 图的信息记录于长度为 n 的二维数组
     * edges，edges[i] = [ai, bi]表示图中在 ai 和 bi 之间存在一条边。
     * <p>
     * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。
     * 如果有多个答案，则返回数组edges中最后出现的边。
     * <p>
     * n == edges.length
     * 3 <= n <= 1000
     * edges[i].length == 2
     * 1 <= ai< bi<= edges.length
     * ai != bi
     * edges 中无重复元素
     * 给定的图是连通的
     */

    List<List<Integer>> to;
    // n：树的节点
    int n;
    // 节点是否访问过
    boolean[] visited;
    // 是否成环
    boolean hasCycle;

    public int[] findRedundantConnection(int[][] edges) {
        n = 0;
        // 统计数的节点个数
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }
        // 初始化
        to = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            to.add(new ArrayList<>());
        }
        visited = new boolean[n + 1];
        // 出边数组
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            // 出边数组加边
            to.get(x).add(y);
            to.get(y).add(x);
            // 初始设置无环
            hasCycle = false;
            dfs(x, 0);
            if (hasCycle) {
                return edge;
            }
        }

        return new int[]{};
    }

    /**
     * 图的深度优先遍历判断环的模板
     *
     * @param x      开始遍历的点
     * @param father 父节点
     */
    public void dfs(int x, int father) {
        visited[x] = true;
        // 出边数组访问x能到的周围点的方法
        for (int y : to.get(x)) {
            // 访问到了父节点，跳过【人为遍历过程产生的环不是真正的环】
            if (y == father) {
                continue;
            }
            // 访问未访问过的边
            if (!visited[y]) {
                dfs(y, x);
            } else {
                // 否则说明已经成环
                hasCycle = true;
            }
        }
        // 还原节点访问情况，不影响后序的访问
        visited[x] = false;
    }

    public static void main(String[] args) {
        FindRedundantConnection findRedundantConnection = new FindRedundantConnection();
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(findRedundantConnection.findRedundantConnection(edges)));
    }
}
