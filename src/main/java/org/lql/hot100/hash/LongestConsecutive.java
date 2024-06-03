package org.lql.hot100.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 21:00
 * @description: 128. 最长连续序列 <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LongestConsecutive {

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * <p>
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */
    public int longestConsecutive(int[] nums) {
        // 边界判断
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 将元素放入set进行去重
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        // 最长连续序列的长度
        int longestStreak = 0;
        // 遍历set中的每个元素
        for (int num : numSet) {
            // 如果当前数字是连续序列的起始点，则遍历该起始点，计算连续序列的长度
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                // 计算连续序列长度
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                // 更新最长连续序列的长度
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        // 4
        System.out.println(longestConsecutive.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        // 9
        System.out.println(longestConsecutive.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        // 3
        System.out.println(longestConsecutive.longestConsecutive(new int[]{1, 2, 0, 1}));
    }
}
