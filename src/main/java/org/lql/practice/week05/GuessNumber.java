package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:16
 * @description: 374. 猜数字大小 <a href="https://leetcode-cn.com/problems/guess-number-higher-or-lower/">...</a>
 */
public class GuessNumber {

    /**
     * 猜数字游戏的规则如下：
     * <p>
     * 每轮游戏，我都会从1到n 随机选择一个数字。 请你猜选出的是哪个数字。
     * 如果你猜错了，我会告诉你，你猜测的数字比我选出的数字是大了还是小了。
     * 你可以通过调用一个预先定义好的接口 int guess(int num) 来获取猜测结果，
     * 返回值一共有 3 种可能的情况（-1，1或 0）：
     * <p>
     * -1：我选出的数字比你猜的数字小 pick < num
     * 1：我选出的数字比你猜的数字大 pick > num
     * 0：我选出的数字和你猜的数字一样。恭喜！你猜对了！pick == num
     * 返回我选出的数字。
     * <p>
     * 1 <= n <= 231 - 1
     * 1 <= pick <= n
     */
    private int pick;

    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int res = guess(mid);
            if (res <= 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private int guess(int num) {
        return Integer.compare(pick, num);
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.pick = 6;
        System.out.println(guessNumber.guessNumber(10));
    }
}
