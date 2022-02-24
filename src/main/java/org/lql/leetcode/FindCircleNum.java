package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/24 11:00 PM
 * @description: 547. 省份数量 https://leetcode-cn.com/problems/number-of-provinces/
 */
public class FindCircleNum {

    /**
     * 有 n 个城市，其中一些彼此相连，另一些没有相连。
     * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
     * <p>
     * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
     * <p>
     * 给你一个 n x n 的矩阵 isConnected ，
     * 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
     * 而 isConnected[i][j] = 0 表示二者不直接相连。
     * <p>
     * 返回矩阵中 省份 的数量。
     */
    private int[] fa;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        fa = new int[n];
        for (int i = 0; i < n; i++) {
            fa[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionSet(i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                ans++;
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

    private void unionSet(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            fa[x] = y;
        }
    }

    public static void main(String[] args) {
        FindCircleNum findCircleNum = new FindCircleNum();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int circleNum = findCircleNum.findCircleNum(isConnected);
        System.out.println(circleNum);
    }
}
