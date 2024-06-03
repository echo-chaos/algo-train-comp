package org.lql.hot100.skill;

import java.util.Arrays;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 00:03
 * @description: 31. 下一个排列 <a href="https://leetcode.cn/problems/next-permutation/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class NextPermutation {

    /**
     * 整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。
     * <p>
     * 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。
     * 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。
     * <p>
     * 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
     * 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
     * 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
     * 给你一个整数数组 nums ，找出 nums 的下一个排列。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * <p>
     * 示例 3：
     * <p>
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 100
     */
    /**
     * “下一个排列”问题要求找到一个序列的下一个字典序排列（即下一个更大的排列），如果不存在这样的排列，则将其重新排列为字典序最小的排列（即升序排列）。
     * <p>
     * 找到第一个下降点：
     * <p>
     * 从右向左扫描数组，找到第一个位置 i，使得 nums[i] < nums[i + 1]。如果不存在这样的 i，说明整个数组已经是非递增的，直接将数组反转并返回即可。
     * <p>
     * 找到要交换的元素：
     * <p>
     * 再次从右向左扫描数组，找到第一个位置 j，使得 nums[j] > nums[i]。这个 j 是我们要和 i 交换的元素。
     * <p>
     * 交换元素：
     * <p>
     * 交换 nums[i] 和 nums[j]，使得左侧部分更接近下一个排列。
     * <p>
     * 反转右侧部分：
     * <p>
     * 最后，将位置 i 之后的部分进行反转，使得它成为最小的字典序排列。
     */
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;

        // Step 1: 从末尾开始查找第一个递减元素
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            // Step 2: 查找刚好大于nums[i]的元素
            int j = n - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // Step 3: 交换nums[i]和nums[j]
            swap(nums, i, j);
        }

        // Step 4: 反转索引i后的元素
        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(new int[]{1, 2, 3});
        nextPermutation.nextPermutation(new int[]{3, 2, 1});
        nextPermutation.nextPermutation(new int[]{1, 1, 5});
    }

}
