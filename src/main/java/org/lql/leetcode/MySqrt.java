package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/1/28 0:54
 * @description: 69. Sqrt(x) https://leetcode-cn.com/problems/sqrtx/
 */
public class MySqrt {

    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        while (l < r) {
            int m = (r + l + 1) / 2 ;
            if ((long) m * m <= x) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        MySqrt mySqrt = new MySqrt();
        int i = mySqrt.mySqrt(8);
        System.out.println(i);
    }
}
