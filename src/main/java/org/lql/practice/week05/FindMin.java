package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:10
 * @description: 153. 寻找旋转排序数组中的最小值 <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">...</a>
 */
public class FindMin {

    /**
     * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
     * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
     * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
     * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
     * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]]
     * 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
     * <p>
     * 给你一个元素值 互不相同 的数组 nums ，
     * 它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
     * <p>
     *
     * <p>
     * n == nums.length
     * 1 <= n <= 5000
     * -5000 <= nums[i] <= 5000
     * nums 中的所有整数 互不相同
     * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
     */
    public int findMin(int[] nums) {
        /*
         * 3 4 5 1 2
         * 0 0 0 1 1
         * 条件单调：因为预先升序排列的数组，通过与nums[right]比较能够得到表示大小关系的0/1
         */
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
        FindMin findMin = new FindMin();
        System.out.println(findMin.findMin(new int[]{3, 4, 5, 1, 2}));
    }
}
