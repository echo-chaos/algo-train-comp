package org.lql.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author: lql
 * @date: 2022/2/1 20:37
 * @description: 1011. 在 D 天内送达包裹的能力 https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class ShipWithinDays {

    /**
     * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
     * <p>
     * 传送带上的第 i个包裹的重量为weights[i]。
     * 每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。
     * 我们装载的重量不会超过船的最大运载重量。
     * <p>
     * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
     * <p>
     * 1 <= days <= weights.length <= 5 * 104
     * 1 <= weights[i] <= 500
     */
    private static final Logger logger = LoggerFactory.getLogger(ShipWithinDays.class);

    public int shipWithinDays(int[] weights, int days) {
        // 运载能力最小值-单个最重包裹
        int min = Arrays.stream(weights).max().getAsInt();
        // 运载能力最大值-所有包裹总量
        int max = Arrays.stream(weights).sum();
        int ans = 0;
        while (min < max) {
            int mid = min + (max - min) / 2;
            int day = 1;
            int capacity = 0;
            for (int weight : weights) {
                // 运载能力超过临界点，运送天数加一，重置运载能力
                if (capacity + weight > mid) {
                    ++day;
                    capacity = 0;
                }
                capacity += weight;
            }
            // 根据运载时间调整运载能力
            if (day <= days) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        ShipWithinDays shipWithinDays = new ShipWithinDays();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int days = days = 5;
        int i = shipWithinDays.shipWithinDays(weights, days);
        System.out.println(i);
    }
}
