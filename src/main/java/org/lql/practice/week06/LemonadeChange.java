package org.lql.practice.week06;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/13 21:38
 * @description: 860. 柠檬水找零 <a href="https://leetcode-cn.com/problems/lemonade-change/description/">...</a>
 */
public class LemonadeChange {

    /**
     * 在柠檬水摊上，每一杯柠檬水的售价为5美元。
     * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
     * <p>
     * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。
     * 你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
     * <p>
     * 注意，一开始你手头没有任何零钱。
     * <p>
     * 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。
     * 如果你能给每位顾客正确找零，返回true，否则返回 false。
     * <p>
     * 1 <= bills.length <= 105
     * bills[i] 不是 5 就是 10 或是 20
     */

    // 零钱数量
    private final Map<Integer, Integer> coins = new HashMap<>();

    public boolean lemonadeChange(int[] bills) {
        coins.put(5, 0);
        coins.put(10, 0);
        coins.put(20, 0);
        for (int bill : bills) {
            coins.put(bill, coins.get(bill) + 1);
            if (!exchange(bill - 5)) {
                return false;
            }
        }
        return true;
    }

    private boolean exchange(int amount) {
        for (int x : new int[]{20, 10, 5}) {
            // 零钱中有x面额的钱时，便优先找零，直到找完所有零钱，是否能满足找零
            while (amount >= x && coins.get(x) > 0) {
                amount -= x;
                coins.put(x, coins.get(x) - 1);
            }
        }
        return amount == 0;
    }

    public static void main(String[] args) {
        LemonadeChange lemonadeChange = new LemonadeChange();
        System.out.println(lemonadeChange.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
    }
}
