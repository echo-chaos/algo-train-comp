package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:23
 * @description: 215. 数组中的第K个最大元素 <a href="https://leetcode-cn.com/problems/kth-largest-element-in-an-array/">...</a>
 */
public class FindKthLargest {

    /**
     * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
     * <p>
     * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
     * <p>
     * 1 <= k <= nums.length <= 104
     * -104 <= nums[i] <= 104
     */
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSort(int[] arr, int l, int r, int index) {
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

    static int partition(int[] a, int l, int r) {
        int pivot = l + (int) (Math.random() * (r - l + 1));
        int pivotVal = a[pivot];
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
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
                l++;
                r--;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        FindKthLargest findKthLargest = new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
