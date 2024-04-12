package org.lql.practice.week02;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:37
 * @description: 1248. 统计「优美子数组」 <a href="https://leetcode-cn.com/problems/count-number-of-nice-subarrays/">...</a>
 */
public class NumberOfSubArrays {

    /**
     * 给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
     * <p>
     * 请返回这个数组中 「优美子数组」 的数目。
     * <p>
     * 原问题：子段的奇数数量
     * 新问题：奇数->1、偶数->0.统计子段和是k的子段数量
     * sum(l,r) == k
     * S[r] - S[l-1] == k (l<=r)
     * 转换为两数之差：
     * S[i] - S[j] = k
     * S[j] = S[i] -k
     */

    public int numberOfSubArrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        // 前缀和,每个数对2取模，转变为0和1，表示奇数和偶数
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] % 2;
        }
        // 记录每个位置的子段和出现次数
        int[] count = new int[nums.length + 1];
        int ans = 0;
        // 初始化时，前缀和为0出现了1次
        count[sum[0]]++;
        for (int i = 1; i <= nums.length; i++) {
            if (sum[i] - k >= 0) {
                // 找到S[j] = S[i] - k的目标数
                ans += count[sum[i] - k];
            }
            // 更新前缀和次数
            count[sum[i]]++;
        }
        System.out.println(Arrays.toString(count));
        return ans;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        // 前缀和,每个数对2取模，转变为0和1，表示奇数和偶数
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] % 2;
        }
        // 使用Map记录每个位置的子段和出现次数
        Map<Integer, Integer> count = new HashMap<>();
        count.put(sum[0], 1); // 初始化时，前缀和为0出现了1次
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (sum[i] - k >= 0) {
                // 获取S[j] = S[i] - k的目标数出现的次数
                ans += count.getOrDefault(sum[i] - k, 0);
            }
            // 更新前缀和出现次数
            count.put(sum[i], count.getOrDefault(sum[i], 0) + 1);
        }
        System.out.println(count);
        return ans;
    }

    public static void main(String[] args) {
        NumberOfSubArrays numberOfSubarrays = new NumberOfSubArrays();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        int number = numberOfSubarrays.numberOfSubArrays(nums, k);
        System.out.println(number);
    }
}
