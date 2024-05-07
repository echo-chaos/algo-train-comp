package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:18
 * @description: 1482. 制作 m 束花所需的最少天数 <a href="https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/">...</a>
 */
public class MinDays {

    /**
     * 给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
     * <p>
     * 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
     * <p>
     * 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
     * <p>
     * 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
     * <p>
     * bloomDay.length == n
     * 1 <= n <= 10^5
     * 1 <= bloomDay[i] <= 10^9
     * 1 <= m <= 10^6
     * 1 <= k <= n
     */
    public int minDays(int[] bloomDay, int m, int k) {
        // 最终绽放的天数
        int latestBloom = 0;
        for (int bloom : bloomDay) {
            // 获取最晚的开花时间
            latestBloom = Math.max(latestBloom, bloom);
        }
        // 二分查找
        int left = 0;
        int right = latestBloom + 1;
        while (left < right) {
            // 二分查找天数
            int mid = (left + right) / 2;
            // 如果制作花束所需的最少天数小于等于mid，则表示可以制作m束花
            if (validByDay(bloomDay, m, k, mid)) {
                // 继续缩小范围
                right = mid;
            } else {
                // 如果制作花束所需的最少天数大于mid，扩大范围
                left = mid + 1;
            }
        }
        // 如果right等于最晚的开花时间+1，则表示无法制作m束花
        if (right == latestBloom + 1) {
            return -1;
        }
        // 返回制作花束所需的最少天数
        return right;
    }

    private boolean validByDay(int[] bloomDay, int m, int k, int day) {
        // 花束
        int bouquet = 0;
        // 连续开放天数
        int consecutive = 0;
        for (int bloom : bloomDay) {
            if (bloom <= day) {
                // 连续开放天数+1
                consecutive++;
                // 如果连续开放天数满足k朵
                if (consecutive == k) {
                    // 可制作的花束+1
                    bouquet++;
                    // 连续开放天数重置
                    consecutive = 0;
                }
            } else {
                // 连续开放天数重置
                consecutive = 0;
            }
        }
        // 可制作的花束>=m
        return bouquet >= m;
    }

    public static void main(String[] args) {
        MinDays minDays = new MinDays();
        // 3
        System.out.println(minDays.minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));
        // -1
        System.out.println(minDays.minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));
        // 12
        System.out.println(minDays.minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));
        // 1000000000
        System.out.println(minDays.minDays(new int[]{1000000000, 1000000000}, 1, 1));
    }
}
