package org.lql.week01;

import org.lql.leetcode.LeetCode88;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2021/12/27 22:55
 * @description: 加一 https://leetcode-cn.com/problems/plus-one/
 */
public class PlusOne {

    private static final Logger logger = LoggerFactory.getLogger(PlusOne.class);

    /**
     * <p>题目：</p>
     * <p>给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。</p>
     * <p>最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。</p>
     * <p>你可以假设除了整数 0 之外，这个整数不会以零开头。</p>
     * <p>示例：</p>
     * <li>输入：digits = [1,2,3] 输出：[1,2,4]</li>
     * <li>输入：digits = [4,3,2,1] 输出：[4,3,2,2]</li>
     *
     * <p>注意：</p>
     * <li>1 <= digits.length <= 100</li>
     * <li>0 <= digits[i] <= 9</li>
     *
     * @param digits 数组
     * @return res
     */
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        //边界判断
        if (length < 1 || length > 100) {
            return null;
        } else if (length > 1 && digits[0] == 0) {
            return null;
        }
        //从数组的尾部开始加一，并判断是否需要进位
        for (int i = length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            //不满足进位直接返回
            if (digits[i] != 0) {
                return digits;
            }
        }
        //全部为9的整数时
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{0, 0, 9};
        logger.info("digits origin -> {}", digits);
        digits = plusOne(digits);
        logger.info("digits result -> {}", digits);
    }
}
