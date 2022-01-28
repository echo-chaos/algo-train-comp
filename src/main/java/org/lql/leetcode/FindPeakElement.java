package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/1/29 0:48
 * @description: 162. 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[ans]){
                ans = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindPeakElement findPeakElement = new FindPeakElement();
        int[] nums = {1,2,3,1};
        int peakElement = findPeakElement.findPeakElement(nums);
        System.out.println(peakElement);
    }
}
