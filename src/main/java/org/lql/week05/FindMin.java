package org.lql.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/7 23:27
 * @description: 154. 寻找旋转排序数组中的最小值 II https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 */
public class FindMin {

    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，
     * 经由 1 到 n 次 旋转 后，得到输入数组。
     * 例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
     * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]
     * 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * <p>
     * 给你一个可能存在 重复 元素值的数组 nums ，
     * 它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * <p>
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     */
    private static final Logger logger = LoggerFactory.getLogger(CountRangeSum.class);

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 原数组：[a[0], a[1], a[2], ..., a[n-1]]
            // x次旋转后的数组：[a[n-x],a[n-x+1]..,a[0],a[1],a[2]...,a[n-x-1]]
            // 是两个有序数组相连
            // 以数组一端作为比较点，进行二分查找
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin();
        int[] nums = {2, 2, 2, 0, 1};
        int min = findMin.findMin(nums);
        System.out.println(min);
    }
}
