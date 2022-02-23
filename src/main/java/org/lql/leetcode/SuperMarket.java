package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/2/24 12:03 AM
 * @description: 超市 https://www.acwing.com/problem/content/147/
 */
public class SuperMarket {

    /**
     * 超市里有 N件商品，每件商品都有利润 pi和过期时间 di，每天只能卖一件商品，过期商品不能再卖。
     * <p>
     * 求合理安排每天卖的商品的情况下，可以得到的最大收益是多少。
     * <p>
     * 数据范围
     * <p>
     * 0≤N≤10000
     * ,
     * 1≤pi,di≤10000
     */

    static List<int[]> temp = new ArrayList<>();
    static int n;
    static int[] fa = new int[10001];

    private static int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    // 4  50 2  10 1   20 2   30 1  -> 80
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            n = s.nextInt();
            for (int i = 0; i < n; i++) {
                temp.add(new int[]{s.nextInt(), s.nextInt()});
            }
//            Collections.sort(temp, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    return Math.max(o1[0], o2[0]);
//                }
//            });
            temp.sort(Comparator.comparingInt(item -> item[0]));
            for (int i = 0; i < fa.length; i++) {
                fa[i] = i;
            }
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                int profit = temp.get(i)[0];
                int day = temp.get(i)[1];
                int lastAvailableDay = find(day);
                if (lastAvailableDay > 0) {
                    ans += profit;
                    fa[lastAvailableDay] = lastAvailableDay - 1;
                }
            }
            System.out.println(ans);
            temp.clear();
        }
        s.close();
    }
}
