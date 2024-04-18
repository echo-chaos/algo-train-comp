package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/11 22:16
 * @description: 22. 括号生成 <a href="https://leetcode-cn.com/problems/generate-parentheses/">...</a>
 */
public class GenerateParenthesis {

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 1 <= n <= 8
     * <p>
     * S = (A)B
     * n = k-1 n-k
     * k=1
     *  (A) A = k- 1 = 1 - 1 = 0对括号 => ()，
     *  B = n - k = 3 - 1 = 2对括号 => ()() (())
     *  ()()() ()(())
     * k=2
     *  (A) A = 1对括号 => (())
     *  B = n - 2 = 1对括号 => ()
     *  (())()
     * k=3
     *  (A) A = 2对括号 => (()()) ((()))
     *  B = 0对括号
     *  (()()) ((()))
     */
    // 记忆存储作用，能及时避免重复的做法
    Map<Integer, List<String>> storage = new HashMap<>();

    public List<String> generateParenthesis(int n) {
        // 边界判断：没有返回空
        if (n == 0) {
            return Collections.singletonList("");
        }
        // 处理已经出现过的答案，提前返回
        if (storage.containsKey(n)) {
            return storage.get(n);
        }
        List<String> ans = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            // S = (A)B = (k-1) n-k
            // (A) 子问题处理
            List<String> left = generateParenthesis(k - 1);
            // B 子问题处理
            List<String> right = generateParenthesis(n - k);
            for (String a : left) {
                for (String b : right) {
                    ans.add("(" + a + ")" + b);
                }
            }
        }
        // 暂存已处理的答案
        storage.put(n, ans);
        return ans;
    }



    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
}
