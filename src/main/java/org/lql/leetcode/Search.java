package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/1/26 22:15
 * @description: 704. 二分查找 https://leetcode-cn.com/problems/binary-search/
 */
public class Search {

    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        while (min <= max){
            int mid = (max - min) / 2 + min;
            int temp = nums[mid];
            if (temp == target){
                return mid;
            } else if (temp < target){
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        int i = search.search(nums, target);
        System.out.println(i);
    }
}
