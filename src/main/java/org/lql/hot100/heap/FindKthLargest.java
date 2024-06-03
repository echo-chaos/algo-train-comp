package org.lql.hot100.heap;

import java.util.Random;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 17:20
 * @description: 215. 数组中的第K个最大元素 <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class FindKthLargest {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,2,1,5,6,4], k = 2
     * 输出: 5
     * <p>
     * 示例 2:
     * <p>
     * 输入: [3,2,3,1,2,4,5,5,6], k = 4
     * 输出: 4
     * <p>
     * 提示：
     * <p>
     * 1 <= k <= nums.length <= 105
     * -104 <= nums[i] <= 104
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSort(int[] arr, int l, int r, int index) {
        if (l >= r) {
            return arr[l];
        }
        int pivot = partition(arr, l, r);
        if (index <= pivot) {
            return quickSort(arr, l, pivot, index);
        } else {
            return quickSort(arr, pivot + 1, r, index);
        }
    }

    public int partition(int[] a, int l, int r) {
        int pivot = new Random().nextInt(r - l + 1);
        int pivotVal = a[l + pivot];
        while (l <= r) {
            while (a[l] < pivotVal) {
                l++;
            }
            while (a[r] > pivotVal) {
                r--;
            }
            if (l == r) {
                break;
            }
            if (l < r) {
                int tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
                l++;
                r--;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = new FindKthLargest().findKthLargest(nums, k);
        System.out.println(kthLargest);
    }
}
