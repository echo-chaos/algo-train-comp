package org.lql.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:42
 * @description: 697. 数组的度 <a href="https://leetcode-cn.com/problems/degree-of-an-array/">...</a>
 */
public class FindShortestSubArray {

    /**
     * 给定一个非空且只包含非负数的整数数组nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
     * <p>
     * 你的任务是在 nums 中找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
     * <p>
     * 输入：nums = [1,2,2,3,1]
     * 输出：2
     * 解释：
     * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
     * 连续子数组里面拥有相同度的有如下所示：
     * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
     * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
     * <p>
     * 输入：nums = [1,2,2,3,1,4,2]
     * 输出：6
     * 解释：
     * 数组的度是 3 ，因为元素 2 重复出现 3 次。
     * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
     * <p>
     * nums.length 在 1 到 50,000 范围内。
     * nums[i] 是一个在 0 到 49,999 范围内的整数。
     */
    public int findShortestSubArray(int[] nums) {
        // int[] 元素的度,初始位置，末位置
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // map中已有数组元素
            if (map.containsKey(nums[i])) {
                // 更新元素的度
                map.get(nums[i])[0]++;
                // 更新元素的末位置的值
                map.get(nums[i])[2] = i;
            } else {
                // map添加 元素：[元素的初始度，元素的初始出现位置，元素的初始末位置]
                map.put(nums[i], new int[]{1, i, i});
            }
        }
        // 元素的度
        int maxNum = 0;
        // 包含元素的数组的长度
        int minLen = 0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[] arr = entry.getValue();
            if (maxNum < arr[0]) {
                // 更新数组的度
                maxNum = arr[0];
                // 更新元素数组的长度
                minLen = arr[2] - arr[1] + 1;
            } else if (maxNum == arr[0]) {
                // 比较相同度下数组的长度
                if (minLen > arr[2] - arr[1] + 1) {
                    minLen = arr[2] - arr[1] + 1;
                }
            }
        }
        return minLen;
    }

    public static void main(String[] args) {
        FindShortestSubArray subArray = new FindShortestSubArray();
//        int[] nums = {1,2,2,3,1};
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        int shortestSubArray = subArray.findShortestSubArray(nums);
        System.out.println(shortestSubArray);
    }
}
