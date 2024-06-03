package org.lql.hot100.skill;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 09:52
 * @description: 287. 寻找重复数 <a href="https://leetcode.cn/problems/find-the-duplicate-number/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class FindDuplicate {

    /**
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
     * <p>
     * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
     * <p>
     * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     * <p>
     * 示例 2：
     * <p>
     * 输入：nums = [3,1,3,4,2]
     * <p>
     * 输出：3
     * 示例 3 :
     * <p>
     * 输入：nums = [3,3,3,3,3]
     * 输出：3
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 105
     * nums.length == n + 1
     * 1 <= nums[i] <= n
     * nums 中 只有一个整数 出现 两次或多次 ，其余整数均只出现 一次
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1, right = n;
        while (left < right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int findDuplicateA(int[] nums) {
        // 初始化 slow 和 fast 指针，分别从起点开始。
        int slow = nums[0];
        int fast = nums[0];
        // 通过循环移动 slow 一步和 fast 两步，直到 slow 和 fast 相遇。
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 将 slow 指针重新指向数组起点，fast 保持在相遇点。
        slow = nums[0];
        // 同时移动 slow 和 fast 指针，每次一步，直到它们再次相遇。相遇的点就是重复的数。
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicateB(int[] nums) {
        int n = nums.length - 1;
        int duplicate = 0;

        // 确定数字的位长度
        int bitLength = Integer.toBinaryString(n).length();

        // 在每个位位置上迭代
        for (int bit = 0; bit < bitLength; bit++) {
            int mask = 1 << bit;
            int bitCountNums = 0;
            int bitCountRange = 0;

            // 计算数组中此位位置的1数
            for (int num : nums) {
                if ((num & mask) != 0) {
                    bitCountNums++;
                }
            }

            // 在1到n的范围内计算此位位置的1数
            for (int i = 1; i <= n; i++) {
                if ((i & mask) != 0) {
                    bitCountRange++;
                }
            }

            // 如果数字中的1多于范围中的1，则此位必须是重复数字的一部分
            if (bitCountNums > bitCountRange) {
                duplicate |= mask;
            }
        }

        return duplicate;
    }

    public int findDuplicateC(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate.findDuplicate(nums));
        System.out.println(findDuplicate.findDuplicateA(nums));
        System.out.println(findDuplicate.findDuplicateB(nums));
        System.out.println(findDuplicate.findDuplicateC(nums));
        System.out.println(findDuplicate.findDuplicateC(new int[]{3, 1, 3, 4, 2}));
    }
}
