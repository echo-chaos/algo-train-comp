package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/1/13 23:10
 * @description: 50. Pow(x, n) https://leetcode-cn.com/problems/powx-n/
 */
public class MyPow {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == -(1 << 31)) {
            return 1.0 / (myPow(x, -(n + 1)) * x);
        }
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        double v = myPow(x, n / 2);
        double ans = v * v;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        MyPow pow = new MyPow();
        double v = pow.myPow(2.00000, 10);
        System.out.println(v);
    }
}
