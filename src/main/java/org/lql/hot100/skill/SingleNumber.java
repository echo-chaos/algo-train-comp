package org.lql.hot100.skill;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 23:32
 * @description: 136. 只出现一次的数字 <a href="https://leetcode.cn/problems/single-number/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SingleNumber {

    /**
     * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * <p>
     * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
     * <p>
     * 示例 1 ：
     * <p>
     * 输入：nums = [2,2,1]
     * 输出：1
     * <p>
     * 示例 2 ：
     * <p>
     * 输入：nums = [4,1,2,1,2]
     * 输出：4
     * <p>
     * 示例 3 ：
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * -3 * 104 <= nums[i] <= 3 * 104
     * 除了某个元素只出现一次以外，其余每个元素均出现两次。
     */
    public int singleNumber(int[] nums) {
        // 使用异或操作找到数组中只出现一次的元素
        // 异或操作的性质：a ^ a = 0, 0 ^ a = a
        // 因此，数组中所有元素进行异或操作，最后的结果就是只出现一次的元素
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{2, 2, 1}));
        System.out.println(new SingleNumber().singleNumber(new int[]{4, 1, 2, 1, 2}));
        System.out.println(new SingleNumber().singleNumber(new int[]{1}));
    }
}
