package org.lql.hot100.binarySearch;

/**
 * @author: liangqinglong
 * @date: 2024-06-01 15:43
 * @description: 153. 寻找旋转排序数组中的最小值 <a href="https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class FindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 5, 1, 2};
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(nums));
    }
}
