package org.lql.practice.week03;

/**
 * @author: lql
 * @date: 2022/2/11 22:14
 * @description: 50. Pow(x, n) <a href="https://leetcode-cn.com/problems/powx-n/">...</a>
 */
public class MyPow {

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn ）。
     * <p>
     * -100.0 < x < 100.0
     * -231 <= n <= 231-1
     * -104 <= xn <= 104
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        // n的值在边界上，处理边界问题
        if (n == -(1 << 31)) {
            return 1.0 / (myPow(x, -(n + 1)) * x);
        }
        // n为负数时，转换为正数再计算，并且转换为负次幂运算
        if (n < 0) {
            return 1.0 / myPow(x, -n);
        }
        double temp = myPow(x, n / 2);
        double ans = temp * temp;
        if (n % 2 == 1) {
            ans *= x;
        }
        return ans;
    }

    public static void main(String[] args) {
        MyPow myPow = new MyPow();
        double v = myPow.myPow(2.00000, 10);
        System.out.print(v);
    }
}
