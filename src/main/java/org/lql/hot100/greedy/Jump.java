package org.lql.hot100.greedy;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 22:54
 * @description: 45. 跳跃游戏 II <a href="https://leetcode.cn/problems/jump-game-ii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Jump {

    /**
     * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
     * <p>
     * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
     * <p>
     * 0 <= j <= nums[i]
     * i + j < n
     * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [2,3,1,1,4]
     * <p>
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * <p>
     * 示例 2:
     * <p>
     * 输入: nums = [2,3,0,1,4]
     * 输出: 2
     * <p>
     * 提示:
     * <p>
     * 1 <= nums.length <= 104
     * 0 <= nums[i] <= 1000
     * 题目保证可以到达 nums[n-1]
     */
    public int jump(int[] nums) {
        int n = nums.length;
        int current = 0;
        int ans = 0;
        while (current < n - 1) {
            // 当前可达范围：[current + 1, right]
            int right = current + nums[current];
            // 如果已经到达边界，则返回
            if (right >= n - 1) {
                return ans + 1;
            }
            // 下一步的可达边界-> nextRight，起跳点-> next
            int nextRight = right;
            int next = 0;
            // 遍历当前可达范围，找到下一步的可达边界-> nextRight，并更新起跳点
            for (int i = current + 1; i <= right; i++) {
                // 如果从当前位置i跳跃后能够达到更远的位置，则更新最远位置和起跳点
                if (i + nums[i] > nextRight) {
                    nextRight = i + nums[i];
                    next = i;
                }
            }
            // 更新当前位置为下一步的可达点
            current = next;
            // 条约次数加一
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Jump jump = new Jump();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump.jump(nums));

    }
}
