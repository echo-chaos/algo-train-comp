package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/3/1 23:58
 * @description: 8. 字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class MyAtoi {

    /**
     * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
     * <p>
     * 函数myAtoi(string s) 的算法如下：
     * <p>
     * 读入字符串并丢弃无用的前导空格
     * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。
     * 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
     * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
     * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。
     * 如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
     * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，
     * 需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
     * 返回整数作为最终结果。
     * 注意：
     * <p>
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
     * <p>
     * 0 <= s.length <= 200
     * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
     */
    public int myAtoi(String s) {
        int index = 0;
        // 忽略空格
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        // 正负号
        int sign = 1;
        if (index < s.length() && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        // 处理数字
        int val = 0;
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            if (val > (Integer.MAX_VALUE - (s.charAt(index) - '0')) / 10) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            val = val * 10 + (s.charAt(index) - '0');
            index++;
        }
        return sign * val;
    }

    public static void main(String[] args) {
        MyAtoi atoi = new MyAtoi();
        int i = atoi.myAtoi("42");
        System.out.println(i);
    }
}
