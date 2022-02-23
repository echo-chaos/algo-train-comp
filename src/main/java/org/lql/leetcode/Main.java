package org.lql.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author:
 * @date: 2022/2/24 12:46 AM
 * @description:
 */
public class Main {

    static int N = 10010;
    static int[][] a;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (s.hasNext()) {
            a = new int[N][2];
            int t = s.nextInt();
            for (int i = 0; i < t; ++i) {
                int pro = s.nextInt();
                int time = s.nextInt();
                a[i] = new int[]{pro, time};
            }

            Arrays.sort(a, 0, t, (a, b) -> a[1] - b[1]);
            PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

            for (int[] arr : a) {
                q.offer(arr);
                if (q.size() > arr[1]) {
                    q.poll();
                }
            }
            int res = 0;
            while (!q.isEmpty()) {
                int[] r = q.poll();
                res += r[0];
            }
            System.out.println(res);
        }
    }
}
