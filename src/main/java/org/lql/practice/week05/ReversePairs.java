package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:24
 * @description: 493. 翻转对 <a href="https://leetcode-cn.com/problems/reverse-pairs/">...</a>
 */
public class ReversePairs {

    /**
     * 给定一个数组nums，
     * 如果i < j且nums[i] > 2*nums[j]我们就将(i, j)称作一个重要翻转对。
     * <p>
     * 你需要返回给定数组中的重要翻转对的数量。
     * <p>
     * 给定数组的长度不会超过50000。
     * 输入数组中的所有数字都在32位整数的表示范围内。
     */
    private int ans;

    public int reversePairs(int[] nums) {
        ans = 0;
        mergeSort(nums, 0, nums.length - 1);
        return ans;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        calculate(arr, left, mid, right);
        merge(arr, left, mid, right);
    }

    void calculate(int[] arr, int left, int mid, int right) {
        int j = mid;
        for (int i = left; i <= mid; i++) {
            while (j < right && arr[i] > 2L * arr[j + 1]) {
                j++;
            }
            ans += j - mid;
        }
    }

    public void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        for (int k = 0; k < temp.length; k++) {
            if (j > right || (i <= mid && arr[i] <= arr[j])) {
                temp[k] = arr[i++];
            } else {
                temp[k] = arr[j++];
            }
        }
        for (int k = 0; k < temp.length; k++) {
            arr[left + k] = temp[k];
        }
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        // 2
        System.out.println(reversePairs.reversePairs(new int[]{1, 3, 2, 3, 1}));
        // 3
        System.out.println(reversePairs.reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(reversePairs.reversePairs(new int[]{2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647}));
    }
}
