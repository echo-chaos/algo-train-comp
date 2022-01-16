package org.lql.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: lql
 * @date: 2022/1/14 23:14
 * @description: 22. 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }

    ArrayList[] cache = new ArrayList[100];

    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            IntStream.range(0, n).forEach(c -> {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            });
        }
        cache[n] = ans;
        return ans;
    }


    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        List<String> list = generateParenthesis.generateParenthesis(3);
        System.out.println(list);
    }
}
