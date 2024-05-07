package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:09
 * @description: 704. 二分查找 <a href="https://leetcode-cn.com/problems/binary-search/">...</a>
 */
public class Search {

    /**
     * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
     * 写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
     * <p>
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }
}
