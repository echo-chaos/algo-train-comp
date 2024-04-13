package org.lql.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:43
 * @description: 1074. 元素和为目标值的子矩阵数量 <a href="https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/">...</a>
 */
public class NumSubmatrixSumTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // 二维压缩层一维
        // 新二维中任意两行之差为原二维任意两行之和
        // 枚举第i行到第j列
        for (int i = 0; i < m; i++) {
            int[] sum = new int[n];
            for (int j = i; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    sum[k] += matrix[j][k];
                }
                // 计算符合条件的子矩阵数量
                ans += subarraySumA(sum, target);
                System.out.println("每次计算的子矩阵：" + Arrays.toString(sum));
                System.out.println(ans);
                System.out.println();
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

    public int subarraySumA(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            int target = sum[i] - k;
            if (map.containsKey(target)) {
                ans += map.get(target);
            }
            map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        NumSubmatrixSumTarget numSubmatrixSumTarget = new NumSubmatrixSumTarget();
        int[][] matrix = {{0, 1, 0}, {1, 1, 1}, {0, 1, 0}};
//        int[][] matrix = {{1, -1}, {-1, 1}};
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        int sumTarget = numSubmatrixSumTarget.numSubmatrixSumTarget(matrix, 0);
        System.out.println("ans: " + sumTarget);
    }
}
