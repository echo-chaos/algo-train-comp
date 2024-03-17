package org.lql.practice.week02;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/9 23:32
 * @description: 167. 两数之和 II - 输入有序数组 <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">...</a>
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int j = numbers.length - 1;
        for (int i = 0; i < numbers.length; i++) {
            while (i < j && numbers[i] + numbers[j] > target) {
                j--;
            }
            if (i < j && numbers[i] + numbers[j] == target) {
                return new int[]{i + 1, j + 1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] numbers = {2,7,11,15};
        int[] ints = twoSum.twoSum(numbers, 9);
        System.out.println(Arrays.toString(ints));
    }
}
