package org.lql.hot100.array;

/**
 * @author: liangqinglong
 * @date: 2024-05-23 16:44
 * @description: 41. 缺失的第一个正数 <a href="https://leetcode.cn/problems/first-missing-positive/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class FirstMissingPositive {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * <p>
     * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,0]
     * 输出：3
     * 解释：范围 [1,2] 中的数字都在数组中。
     * 示例 2：
     * <p>
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 解释：1 在数组中，但 2 没有。
     * 示例 3：
     * <p>
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * 解释：最小的正数 1 没有出现。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     */
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // nums[i] = i + 1
        for (int i = 0; i < n; i++) {
            // 将 nums[i] 放到正确的位置上
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        // 找到第一个不满足 nums[i] == i + 1 的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 如果所有位置都满足条件，缺失的第一个正数就是 n + 1
        return n + 1;
    }

    public int firstMissingPositive1(int[] nums) {
        int n = nums.length;
        // 将数组中所有非正整数替换为一个大于数组长度的正整数，避免与数组长度及以内正整数混淆。
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        // 遍历数组，通过标记对应位置的元素为负数来表示该正整数存在。
        // 使用绝对值操作确保遍历过程中不会因为负数而出现错误。
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        // 遍历数组找到第一个正数对应的索引，即为缺失的第一个正整数。
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        // 如果数组中所有位置都被标记为负数，则返回数组长度加一。
        return n + 1;
    }


    public static void main(String[] args) {
        FirstMissingPositive solution = new FirstMissingPositive();
        // 2
        System.out.println(solution.firstMissingPositive(new int[]{3, 4, -1, 1}));
        // 3
        System.out.println(solution.firstMissingPositive(new int[]{1, 2, 0}));
        // 1
        System.out.println(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        // 2
        System.out.println(solution.firstMissingPositive1(new int[]{3, 4, -1, 1}));
        // 3
        System.out.println(solution.firstMissingPositive1(new int[]{1, 2, 0}));
        // 1
        System.out.println(solution.firstMissingPositive1(new int[]{7, 8, 9, 11, 12}));
    }
}
