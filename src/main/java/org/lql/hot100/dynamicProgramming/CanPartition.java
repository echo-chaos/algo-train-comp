package org.lql.hot100.dynamicProgramming;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 16:48
 * @description: 416. 分割等和子集 <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class CanPartition {

    /**
     * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,5,11,5]
     * 输出：true
     * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3,5]
     * 输出：false
     * 解释：数组不能分割成两个元素和相等的子集。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 200
     * 1 <= nums[i] <= 100
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        // 初始化动态规划数组，dp[j]表示是否可以使用数组中的部分元素凑出和为j
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                // 如果当前和j能够由之前的和j-num加上当前元素num得到，且这个和更大，则更新dp[j]
                dp[j] = Math.max(dp[j], dp[j - num] + num);
            }
        }
        return dp[target] == target;
    }

    public boolean canPartitionA(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            // Update the dp array from back to front
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5}));
    }
}
