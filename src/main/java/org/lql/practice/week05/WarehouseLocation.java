package org.lql.practice.week05;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: lql
 * @date: 2022/2/13 21:28
 * @description: 货仓选址 <a href="https://www.acwing.com/solution/content/5382/">...</a>
 */
public class WarehouseLocation {

    public static void main(String[] args) {
        // 4
        // 6 2 9 1
        // 12
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);
        int mid = (n - 1) / 2;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs((A[mid] - A[i]));
        }
        System.out.println(sum);
    }
}
