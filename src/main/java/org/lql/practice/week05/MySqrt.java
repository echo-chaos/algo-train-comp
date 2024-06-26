package org.lql.practice.week05;

/**
 * @author: lql
 * @date: 2022/2/13 21:13
 * @description: 69. x 的平方根  <a href="https://leetcode-cn.com/problems/sqrtx/">...</a>
 */
public class MySqrt {

    /**
     * 给你一个非负整数 x ，计算并返回x的 算术平方根 。
     * <p>
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     * <p>
     * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
     * <p>
     * 0 <= x <= 231 - 1
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (mid <= x / mid) {// 防止算数溢出
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        System.out.println(mySqrt.mySqrt(4));
        System.out.println(mySqrt.mySqrt(8));
    }
}
