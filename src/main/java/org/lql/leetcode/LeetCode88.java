package org.lql.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2021/12/27 14:11
 * @description: 88. 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array
 */
public class LeetCode88 {

    private static final Logger logger = LoggerFactory.getLogger(LeetCode88.class);

    /*
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -109 <= nums1[i], nums2[j] <= 109
     */

    /**
     * @param nums1 数组1
     * @param m     数组1长度
     * @param nums2 数组2
     * @param n     数组2长度
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //边界校验
        if (m == 0) {
            //src srcPos dest destPos length
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        if (n == 0) {
            return;
        }
        int[] res = new int[m + n];
        int pm = 0;
        int pn = 0;
        int temp;
        while (pm < m || pn < n) {
            if (pm == m) {
                temp = nums2[pn++];
            } else if (pn == n) {
                temp = nums1[pm++];
            } else if (nums1[pm] < nums2[pn]) {
                temp = nums1[pm++];
            } else {
                temp = nums2[pn++];
            }
            res[pm + pn - 1] = temp;
        }
        System.arraycopy(res, 0, nums1, 0, m + n);
    }



    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);
        logger.info("merged -> {}", nums1);
    }

}
