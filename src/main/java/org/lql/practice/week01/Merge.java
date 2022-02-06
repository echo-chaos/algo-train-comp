package org.lql.practice.week01;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/2 16:57
 * @description: 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            // j出界 || ij未出界，要大的
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[k] = nums1[i--];
            } else {
                nums1[k] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}
