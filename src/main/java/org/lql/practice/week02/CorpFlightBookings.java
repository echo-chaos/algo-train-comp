package org.lql.practice.week02;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/3 22:38
 * @description: 1109. 航班预订统计 <a href="https://leetcode-cn.com/problems/corporate-flight-bookings/">...</a>
 */
public class CorpFlightBookings {

    /**
     * 差分-前缀
     * <p>
     * 这里有 n 个航班，它们分别从 1 到 n 进行编号。
     * <p>
     * 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
     * <p>
     * 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
     * <p>
     * 输入：bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
     * 输出：[10,55,45,25,25]
     * 解释：
     * 航班编号        1   2   3   4   5
     * 预订记录 1 ：   10  10
     * 预订记录 2 ：       20  20
     * 预订记录 3 ：       25  25  25  25
     * 总座位数：      10  55  45  25  25
     * 因此，answer = [10,55,45,25,25]
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        // 差分计算
        int[] delta = new int[n + 2];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            delta[first] += seats;
            delta[last + 1] -= seats;
        }
        // 前缀和计算
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + delta[i];
        }
        System.out.println(Arrays.toString(sum));
        // 结果置换
        int[] ans = new int[n];
        System.arraycopy(sum, 1, ans, 0, n);
        return ans;
    }

    public int[] corpFlightBookingsLeetCode(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                nums[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }


    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ints = corpFlightBookings.corpFlightBookings(bookings, 5);
        int[] intsLeetCode = corpFlightBookings.corpFlightBookingsLeetCode(bookings, 5);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(intsLeetCode));
    }
}
