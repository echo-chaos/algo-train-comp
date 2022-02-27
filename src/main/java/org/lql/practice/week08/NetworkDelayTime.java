package org.lql.practice.week08;

/**
 * @author: lql
 * @date: 2022/2/28 1:38 AM
 * @description: 743. 网络延迟时间 https://leetcode-cn.com/problems/network-delay-time/
 */
public class NetworkDelayTime {

    /**
     * 有 n 个网络节点，标记为1到 n。
     * <p>
     * 给你一个列表times，表示信号经过 有向 边的传递时间。times[i] = (ui, vi, wi)，
     * 其中ui是源节点，vi是目标节点， wi是一个信号从源节点传递到目标节点的时间。
     * <p>
     * 现在，从某个节点K发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回-1 。
     * <p>
     * 1 <= k <= n <= 100
     * 1 <= times.length <= 6000
     * times[i].length == 3
     * 1 <= ui, vi <= n
     * ui != vi
     * 0 <= wi <= 100
     * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        return 1;
    }
}
