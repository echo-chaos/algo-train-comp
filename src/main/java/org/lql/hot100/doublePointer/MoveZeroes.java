package org.lql.hot100.doublePointer;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 21:21
 * @description: 283. 移动零 <a href="https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MoveZeroes {
    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 示例 2:
     * <p>
     * 输入: nums = [0]
     * 输出: [0]
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * -231 <= nums[i] <= 231 - 1
     */
    public void moveZeroes(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[cnt++] = nums[i];
            }
        }
        while (cnt < nums.length) {
            nums[cnt++] = 0;
        }
    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] ints = {0, 1, 0, 3, 12};
        moveZeroes.moveZeroes(ints);
        System.out.println(Arrays.toString(ints));
        int[] ints1 = {0};
        moveZeroes.moveZeroes(ints1);
        System.out.println(Arrays.toString(ints1));
        int[] ints2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        moveZeroes.moveZeroes(ints2);
        System.out.println(Arrays.toString(ints2));
    }
}
