package org.lql.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author: lql
 * @date: 2022/2/28 1:22 AM
 * @description: 136. 邻值查找 https://www.acwing.com/problem/content/description/138/
 */
public class NeighborSearch {

    public static void main(String[] args) {
        Set<HashMap<Integer,Integer>> set = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            System.out.println(set);
        }
    }
}
