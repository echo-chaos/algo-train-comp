package org.lql.hot100.binarySearch;

/**
 * @author: liangqinglong
 * @date: 2024-06-01 15:48
 * @description: 4. 寻找两个正序数组的中位数 <a href="https://leetcode.cn/problems/median-of-two-sorted-arrays/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class FindMedianSortedArrays {

    /**
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * <p>
     * 算法的时间复杂度应该为 O(log (m+n)) 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * <p>
     * 提示：
     * <p>
     * nums1.length == m
     * nums2.length == n
     * 0 <= m <= 1000
     * 0 <= n <= 1000
     * 1 <= m + n <= 2000
     * -106 <= nums1[i], nums2[i] <= 106
     */

    /**
     * A[...] -> m <p>
     * b[...] -> n <p>
     * 中位数：k = (m + n) / 2 或 k = (m + n) / 2 + 1 <p>
     * 中位数即是两个数组中第 k 大的数 <p>
     * 通过二分法，找到两个数组中第 k 大的数: <p>
     * 比较：A[k/2 - 1] 和 B[k/2 - 1] 的值 <p>
     * (1): A[k/2 - 1] <  B[k/2 - 1] 排除 A[0] ~ A[k/2 - 1] <p>
     * (2): A[k/2 - 1] >  B[k/2 - 1] 排除 B[0] ~ B[k/2 - 1] <p>
     * (3): A[k/2 - 1] == B[k/2 - 1] 排除 A[0] ~ A[k/2 - 1]<p>
     * 特殊情况：<p>
     * - A[k/2 - 1]或B[k/2 - 1]越界，取对应数组的最后一个值 <p>
     * - A[] 或 B[] 为空，直接返回另一个数组的中位数 <p>
     * - k = 1 时，直接返回两个数组首元素最小值 <p>
     */

    private int[] nums1;
    private int[] nums2;
    int m, n;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        m = nums1.length;
        n = nums2.length;
        int tot = m + n;
        // 判断两个数组的总长度的奇偶性
        if (tot % 2 == 1) {
            int mid = tot / 2 + 1;
            return getMedian(mid);
        } else {
            int midLeft = tot / 2;
            int midRight = tot / 2 + 1;
            return (getMedian(midLeft) + getMedian(midRight)) / 2.0;
        }
    }

    /* 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
     * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
     * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
     * 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
     * 这样 pivot 本身最大也只能是第 k-1 小的元素
     * 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
     * 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
     * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小），因此需要修改 k 的值，减去删除的数的个数
     */

    public int getMedian(int mid) {

        int i = 0;
        int j = 0;
        while (true) {
            // 边界值判断
            if (i == m) { // nums1 到达末尾
                return nums2[j + mid - 1];
            }
            if (j == n) { // nums2 到达末尾
                return nums1[i + mid - 1];
            }
            if (mid == 1) { // 找到中位数
                return Math.min(nums1[i], nums2[j]);
            }
            // 常规情况
            int half = mid / 2;
            int newI = Math.min(i + half, m) - 1;
            int newJ = Math.min(j + half, n) - 1;
            int pivot1 = nums1[newI];
            int pivot2 = nums2[newJ];
            if (pivot1 <= pivot2) {
                mid -= (newI - i + 1);
                i = newI + 1;
            } else {
                mid -= (newJ - j + 1);
                j = newJ + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 3};
        int[] nums2 = new int[]{2};
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double medianSortedArrays = findMedianSortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }
}
