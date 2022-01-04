package org.lql.practice.week01;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/3 16:27
 * @description: 283. 移动零 https://leetcode-cn.com/problems/move-zeroes/
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[n++] = nums[i];
            }
        }
        while (n < nums.length){
            nums[n++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums = {0,1,0,3,12};
        System.out.println(Arrays.toString(nums));
        moveZeroes.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
