package org.lql.practice.week01;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/2 16:57
 * @description: 88. 合并两个有序数组 <a href="https://leetcode-cn.com/problems/merge-sorted-array/">...</a>
 */
public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 正序操作会出现两个数组偏移量差别造成nums1数组元素被覆盖，所以采用倒序操作
        // i，j两个指针分别从nums1、nums2两个数组末尾开始移动
        int i = m - 1;
        int j = n - 1;
        // k：计数器，记录最终nums1数组第k个位置的存放元素
        for (int k = m + n - 1; k >= 0; k--) {
            // nums1数组取值：j出界 || ij未出界，要大的
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
