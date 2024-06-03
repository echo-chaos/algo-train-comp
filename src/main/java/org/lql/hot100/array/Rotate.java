package org.lql.hot100.array;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-05-23 15:31
 * @description: 189. 轮转数组 <a href="https://leetcode.cn/problems/rotate-array/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Rotate {

    /**
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * <p>
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // 求余
        k = k % n;
        int[] rotatedArray = new int[n];

        // 将元素放入新位置
        for (int i = 0; i < n; i++) {
            rotatedArray[(i + k) % n] = nums[i];
        }

        // 将新数组的内容复制回原数组
        System.arraycopy(rotatedArray, 0, nums, 0, n);
    }

    /**
     * 旋转数组。
     * 将一个数组的所有元素向右移动k个位置，其中k是非负数。
     *
     * @param nums 待旋转的整数数组。
     * @param k    旋转的位置数。
     */
    public void rotateA(int[] nums, int k) {
        int n = nums.length;
        // 取余确保k在[0, n)的范围内
        k = k % n;
        // 记录已旋转的元素数量
        int count = 0;

        // 对数组中的每个元素进行旋转操作，直到所有元素都被旋转
        for (int start = 0; count < n; start++) {
            // 当前操作的元素下标
            int current = start;
            // 上一个旋转的元素值
            int prev = nums[start];
            // 对当前元素进行循环旋转，直到回到起始位置
            do {
                // 计算下一个要旋转的元素下标
                int next = (current + k) % n;
                // 保存下一个要旋转的元素值
                int temp = nums[next];
                // 将上一个元素的值放到下一个位置
                nums[next] = prev;
                // 更新上一个元素的值为当前处理的元素值
                prev = temp;
                // 更新当前元素下标
                current = next;
                // 增加已旋转的元素数量
                count++;
            } while (start != current);
        }
    }

    public void rotateB(int[] nums, int k) {
        int n = nums.length;
        // 取余确保k在[0, n)的范围内
        k = k % n;
        // 翻转整个数组
        reverse(nums, 0, n - 1);
        // 翻转前k个元素
        reverse(nums, 0, k - 1);
        // 翻转后n-k个元素
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        Rotate rotate = new Rotate();
        System.out.println(Arrays.toString(nums));
        rotate.rotateB(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
