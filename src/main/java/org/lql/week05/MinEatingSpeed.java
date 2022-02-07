package org.lql.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/7 21:51
 * @description: 875. 爱吃香蕉的珂珂 https://leetcode-cn.com/problems/koko-eating-bananas/
 */
public class MinEatingSpeed {

    /**
     * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
     * <p>
     * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。
     * 每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
     * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
     * <p>
     * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
     * <p>
     * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
     * <p>
     * 1 <= piles.length <= 10^4
     * piles.length <= H <= 10^9
     * 1 <= piles[i] <= 10^9
     */
    private static final Logger logger = LoggerFactory.getLogger(MinEatingSpeed.class);

    public int minEatingSpeed(int[] piles, int h) {
        int slow = 1;
        int fast = 1_000_000_000;
        while (slow < fast) {
            int mid = slow + (fast - slow) / 2;
            int time = 0;
            // 以mid为速度吃香蕉耗时
            for (int pile : piles) {
                // 每个小时都会吃掉N堆香蕉中的k根香蕉
                // 吃得完刚好，吃不完再吃一回
                time += pile % mid == 0 ? pile / mid : pile / mid + 1;
            }
            // 根据耗时调整速度
            if (time <= h) {
                fast = mid;
            } else {
                slow = mid + 1;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int i = minEatingSpeed.minEatingSpeed(piles, h);
        System.out.println(i);
    }
}
