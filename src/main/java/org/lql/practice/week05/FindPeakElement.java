package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:14
 * @description: 162. 寻找峰值 <a href="https://leetcode-cn.com/problems/find-peak-element/">...</a>
 */
public class FindPeakElement {

    /**
     * 峰值元素是指其值严格大于左右相邻值的元素。
     * <p>
     * 给你一个整数数组nums，找到峰值元素并返回其索引。
     * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
     * <p>
     * 你可以假设nums[-1] = nums[n] = -∞ 。
     * <p>
     * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
     * <p>
     * 1 <= nums.length <= 1000
     * -231 <= nums[i] <= 231 - 1
     * 对于所有有效的 i 都有 nums[i] != nums[i + 1]
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int lmid = (left + right) / 2;
            int rmid = lmid + 1;
            if (nums[lmid] <= nums[rmid]) {
                left = lmid + 1;
            } else {
                right = rmid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        // 2
        System.out.println(findPeakElement.findPeakElement(new int[]{1, 2, 3, 1}));
        // 1/5
        System.out.println(findPeakElement.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }
}
