package org.lql.practice.week02;

/**
 * @author: lql
 * @date: 2022/1/3 22:37
 * @description: 1248. 统计「优美子数组」 https://leetcode-cn.com/problems/count-number-of-nice-subarrays/
 */
public class NumberOfSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        // 前缀和
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1] % 2;
        }
        int[] count = new int[nums.length + 1];
        int ans = 0;
        count[sum[0]]++;
        // 两数差 ~
        // s[r - l] = k ~
        // s[r] - s[l-1] = k ~
        // s[l - k] = s[r] - k
        for (int i = 1; i <= nums.length; i++) {
            if (sum[i] - k >= 0) {
                ans += count[sum[i] - k];
            }
            count[sum[i]]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        NumberOfSubarrays numberOfSubarrays = new NumberOfSubarrays();
        int[] nums = {1,1,2,1,1};
        int k = 3;
        int number = numberOfSubarrays.numberOfSubarrays(nums, k);
        System.out.println(number);
    }
}
