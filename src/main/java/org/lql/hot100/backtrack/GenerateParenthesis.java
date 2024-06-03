package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 15:36
 * @description: 22. 括号生成 <a href="https://leetcode.cn/problems/generate-parentheses/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class GenerateParenthesis {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * <p>
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 8
     */
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return Collections.singletonList("");
        }
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            List<String> left = generateParenthesis(i - 1);
            List<String> right = generateParenthesis(n - i);
            for (String l : left) {
                for (String r : right) {
                    res.add("(" + l + ")" + r);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
