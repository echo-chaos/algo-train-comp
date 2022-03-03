package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/2/28 1:20 AM
 * @description: 850. Dijkstra求最短路 II https://www.acwing.com/problem/content/852/
 */
public class Dijkstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<List<Integer>> ver = new ArrayList<>();
        List<List<Integer>> edge = new ArrayList<>();
        boolean[] v = new boolean[n+1];
        int[] d = new int[n+1];
        PriorityQueue<int[]> q;
        for (int i = 0; i <= n; i++) {
            ver.add(new ArrayList<>());
            edge.add(new ArrayList<>());
            v[i] = false;
            d[i] = 1_000_000_000;
        }
        d[1] = 0;
        q = new PriorityQueue<>(Comparator.comparing(a -> a[1]));
        q.offer(new int[]{1,0});
        for (int i = 1; i <= m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            ver.get(x).add(y);
            edge.get(x).add(z);
        }
        while (!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[0];
            if (v[x]){
                continue;
            }
            v[x] = true;
            for (int i = 0; i < ver.get(x).size(); i++) {
                int y = ver.get(x).get(i);
                int z = edge.get(x).get(i);
                if (d[y] > d[x] + z){
                    d[y] = d[x] + z;
                    q.offer(new int[]{y,d[y]});
                }
            }
        }
        int res = d[n] == 1_000_000_000 ? -1 : d[n];
        System.out.println(res);
    }
}
