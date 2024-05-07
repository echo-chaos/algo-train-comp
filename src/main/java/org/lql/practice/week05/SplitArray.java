package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:17
 * @description: 410. 分割数组的最大值 <a href="https://leetcode-cn.com/problems/split-array-largest-sum/">...</a>
 */
public class SplitArray {

    /**
     * 给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
     * <p>
     * 设计一个算法使得这 m 个子数组各自和的最大值最小。
     * <p>
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 106
     * 1 <= m <= min(50, nums.length)
     */
    public int splitArray(int[] nums, int m) {
        int left = 0;
        int right = 0;
        for (int num : nums) {
            // 获取盒子的右边界
            right += num;
            // 获取盒子的左边界
            left = Math.max(left, num);
        }
        // 二分查找
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValid(nums, m, mid)) {
                // 满足条件，将右边界缩小
                right = mid;
            } else {
                // 不满足条件，将左边界扩大
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * 判定方法
     *
     * @param nums     数组
     * @param m        分割的个数
     * @param boundary 边界
     * @return 是否满足条件
     */
    private boolean isValid(int[] nums, int m, int boundary) {
        // 盒子：存放元素
        int box = 0;
        // 盒子的数量
        int count = 1;
        // 遍历数组
        for (int num : nums) {
            // 如果当前元素+盒子中的元素小于边界，则将元素放入盒子中
            if (box + num <= boundary) {
                box += num;
            } else {
                // 如果当前元素+盒子中的元素大于边界，则将盒子中的元素放入新盒子中，并且将盒子的数量+1
                count++;
                box = num;
            }
        }
        // 判定最终盒子的数量是否满足条件
        return count <= m;
    }

    public static void main(String[] args) {
        SplitArray splitArray = new SplitArray();
        // 18
        System.out.println(splitArray.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        // 9
        System.out.println(splitArray.splitArray(new int[]{1, 2, 3, 4, 5}, 2));
        // 4
        System.out.println(splitArray.splitArray(new int[]{1, 4, 4}, 3));
    }
}
