package org.lql.practice.week05;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: lql
 * @date: 2022/2/13 21:19
 * @description: 912. 排序数组 <a href="https://leetcode-cn.com/problems/sort-an-array/">...</a>
 */
public class SortArray {

    /**
     * 给你一个整数数组 nums，请你将该数组升序排列。
     * <p>
     * 1 <= nums.length <= 5 * 104
     * -5 * 104 <= nums[i] <= 5 * 104
     */
    public int[] sortArray(int[] nums) {
        return nums;
    }

    /**
     * 选择排序
     */
    public int[] sortArrayBySelect(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 最小值索引
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 找到最小值
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            // 交换元素
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
        return nums;
    }

    /**
     * 插入排序
     */
    public int[] sortArrayByInsert(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 待插入元素
            int temp = nums[i];
            // 待插入位置
            int j = i - 1;
            // 找到插入位置
            while (j >= 0 && nums[j] > temp) {
                nums[j + 1] = nums[j];
                j--;
            }
            // 插入元素
            nums[j + 1] = temp;
        }
        return nums;
    }

    /**
     * 冒泡排序
     */
    public int[] sortArrayByBubble(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    // swap arr[j] and arr[j+1]
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 堆排序
     */
    public int[] sortArrayByHeap(int[] nums) {
        // 优先队列默认是小顶堆
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = pq.poll();
        }
        return nums;
    }

    public void heapSort(int[] arr) {
        int n = arr.length;
        // 生成堆（重新排列数组）
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // 逐个从堆中提取元素
        for (int i = n - 1; i > 0; i--) {
            // 将当前根移动到底
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // 在减少的堆上调用max-heapify
            heapify(arr, i, 0);
        }
    }

    // 堆积以节点i为根的子树 arr[]中的一个索引。n是堆的大小
    void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    /**
     * 希尔排序
     */
    public int[] sortArrayByShell(int[] nums) {
        for (int gap = nums.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < nums.length; i++) {
                int temp = nums[i];
                int j = i - gap;
                while (j >= 0 && nums[j] > temp) {
                    nums[j + gap] = nums[j];
                    j -= gap;
                }
                nums[j + gap] = temp;
            }
        }
        return nums;
    }

    /**
     * 归并排序
     */
    public int[] sortArrayByMerge(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
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

    /**
     * 快速排序
     */
    public int[] sortArrayByQuick(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = partition(arr, l, r);
        quickSort(arr, l, pivot);
        quickSort(arr, pivot + 1, r);
    }

    static int partition(int[] a, int l, int r) {
        int pivot = l + (int) (Math.random() * (r - l + 1));
        int pivotVal = a[pivot];
        while (l <= r) {
            while (a[l] < pivotVal) l++;
            while (a[r] > pivotVal) r--;
            if (l == r) break;
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
        SortArray sortArray = new SortArray();
        System.out.println("选择排序：" + Arrays.toString(sortArray.sortArrayBySelect(new int[]{5, 2, 3, 1})));
        System.out.println("插入排序：" + Arrays.toString(sortArray.sortArrayByInsert(new int[]{5, 2, 3, 1})));
        System.out.println("冒泡排序：" + Arrays.toString(sortArray.sortArrayByBubble(new int[]{5, 2, 3, 1})));
        System.out.println("小堆排序：" + Arrays.toString(sortArray.sortArrayByHeap(new int[]{5, 2, 3, 1})));
        System.out.println("希尔排序：" + Arrays.toString(sortArray.sortArrayByShell(new int[]{5, 2, 3, 1})));
        System.out.println("归并排序：" + Arrays.toString(sortArray.sortArrayByMerge(new int[]{5, 2, 3, 1})));
        System.out.println("快速排序：" + Arrays.toString(sortArray.sortArrayByQuick(new int[]{5, 2, 3, 1})));
    }

}
