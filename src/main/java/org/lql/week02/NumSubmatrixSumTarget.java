package org.lql.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:43
 * @description: 1074. 元素和为目标值的子矩阵数量 https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/
 */
public class NumSubmatrixSumTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // 二维数组矩阵 ---> 一维前缀和
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] += matrix[j][k];
                }
                System.out.println(Arrays.toString(sum));
                ans += subarraySum(sum, target);
            }
        }
        return ans;
    }

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        NumSubmatrixSumTarget numSubmatrixSumTarget = new NumSubmatrixSumTarget();
//        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
        int[][] matrix = {{1, -1}, {-1, 1}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        int sumTarget = numSubmatrixSumTarget.numSubmatrixSumTarget(matrix, 0);
        System.out.println(sumTarget);
    }
}
