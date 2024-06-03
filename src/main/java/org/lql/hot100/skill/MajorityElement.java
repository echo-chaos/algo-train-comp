package org.lql.hot100.skill;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 23:37
 * @description: 169. 多数元素 <a href="https://leetcode.cn/problems/majority-element/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MajorityElement {

    /**
     * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     * <p>
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [3,2,3]
     * 输出：3
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [2,2,1,1,1,2,2]
     * 输出：2
     * <p>
     * <p>
     * 提示：
     * n == nums.length
     * 1 <= n <= 5 * 104
     * -109 <= nums[i] <= 109
     */
    public int majorityElement(int[] nums) {
        // 投票计数
        int count = 0;
        // 候选元素初始化
        int candidate = 0;
        for (int num : nums) {
            // 候选元素初始化
            if (count == 0) {
                candidate = num;
            }
            // 投票：如果候选元素和当前元素相同，则计数器加1；否则减1
            count += (num == candidate) ? 1 : -1;
        }
        // 验证所选候选是否满足多数元素条件
//        int occurrences = 0;
//        for (int num : nums) {
//            if (num == candidate) {
//                occurrences++;
//                if (occurrences > nums.length / 2) {
//                    return candidate;
//                }
//            }
//        }
        // 多数元素会胜出
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3}));
    }
}
