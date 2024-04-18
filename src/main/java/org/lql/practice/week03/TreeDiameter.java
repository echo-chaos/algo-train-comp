package org.lql.practice.week03;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * @description: 树的直径
 * @author: liangqinglong
 * @date: 2024-04-17 20:15
 **/
public class TreeDiameter {

    // 点与点之间的联系
    List<List<Integer>> to;
    // n：树的节点
    int n;

    public int treeDiameter(int[][] edges) {
        // 统计节点数量
        n = 0;
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            n = Math.max(n, Math.max(x, y));
        }
        n++;
        // 初始化节点访问关系，最开始为空
        to = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            to.add(new ArrayList<>());
        }
        // 出边数组
        for (int[] edge : edges) {
            // 获取节点
            int x = edge[0];
            int y = edge[1];
            // 相邻节点可以互相访问
            to.get(x).add(y);
            to.get(y).add(x);
        }
        // 从0开始寻找能访问到的最远的节点
        Integer point = findFarthest(0).getPoint();
        // 从最远的点再次出发寻找当前点能到达的最远点
        return findFarthest(point).getDistance();
    }

    public Pair<Integer, Integer> findFarthest(int start) {
        // 初始化节点深度数组，全部设置为-1，表示未访问
        int[] depth = IntStream.generate(() -> -1).limit(n).toArray();
        // 使用队列来进行广度优先搜索
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        // 起始节点深度为0
        depth[start] = 0;
        // 广度优先搜索
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y : to.get(x)) {
                // 走过了的节点
                if (depth[y] != -1) {
                    continue;
                }
                // 设置邻居节点的深度，并将其加入队列进行后续访问
                depth[y] = depth[x] + 1;
                queue.offer(y);
            }
        }
        // 寻找最远节点
        int ans = start;
        for (int i = 0; i < n; i++) {
            if (depth[i] > depth[ans]) {
                ans = i;
            }
        }
        return new Pair<>(ans, depth[ans]);
    }


    public static void main(String[] args) {
        TreeDiameter treeDiameter = new TreeDiameter();
        // 2
        int[][] edges = new int[][]{{0, 1}, {0, 2}};
        System.out.println(treeDiameter.treeDiameter(edges));
        // 4
        int[][] nums = new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}};
        System.out.println(treeDiameter.treeDiameter(nums));
    }

    /**
     * 点 - 距离 的二元组
     *
     * @param <P> 节点
     * @param <D> 距离
     */
    public static class Pair<P, D> {
        private final P point;
        private final D distance;

        public Pair(P point, D distance) {
            this.point = point;
            this.distance = distance;
        }

        public P getPoint() {
            return point;
        }

        public D getDistance() {
            return distance;
        }
    }
}
