package org.lql.practice.week02;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/3 22:38
 * @description: 1109. 航班预订统计 https://leetcode-cn.com/problems/corporate-flight-bookings/
 */
public class CorpFlightBookings {

    /**
     * 差分-前缀
     */

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] delta = new int[n + 2];
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            delta[first] += seats;
            delta[last + 1] -= seats;
        }
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + delta[i];
        }
        int[] ans = new int[n];
        System.arraycopy(sum, 1, ans, 0, n);
        return ans;
    }

    public static void main(String[] args) {
        CorpFlightBookings corpFlightBookings = new CorpFlightBookings();
        int[][] bookings = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        int[] ints = corpFlightBookings.corpFlightBookings(bookings, 5);
        System.out.println(Arrays.toString(ints));
    }
}
