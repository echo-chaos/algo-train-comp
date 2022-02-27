package org.lql.practice.week08;

/**
 * @author: lql
 * @date: 2022/2/28 1:39 AM
 * @description: 1334. 阈值距离内邻居最少的城市 https://leetcode-cn.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
 */
public class FindTheCity {

    /**
     * 有 n个城市，按从 0 到 n-1编号。给你一个边数组edges，
     * 其中 edges[i] = [fromi, toi, weighti]代表fromi和toi两个城市之间的双向加权边，
     * 距离阈值是一个整数distanceThreshold。
     * <p>
     * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为distanceThreshold的城市。
     * 如果有多个这样的城市，则返回编号最大的城市。
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
        return 0;
    }
}
