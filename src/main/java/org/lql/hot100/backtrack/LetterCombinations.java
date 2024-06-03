package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 15:16
 * @description: 17. 电话号码的字母组合 <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LetterCombinations {

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * <p>
     * 示例 2：
     * <p>
     * 输入：digits = ""
     * 输出：[]
     * <p>
     * 示例 3：
     * <p>
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     * <p>
     * 提示：
     * <p>
     * 0 <= digits.length <= 4
     * digits[i] 是范围 ['2', '9'] 的一个数字。
     */
    private String digits;

    private Map<Character, String> alphabet;

    private List<String> ans;

    public List<String> letterCombinations(String digits) {
        this.digits = digits;
        alphabet = new HashMap<>();
        alphabet.put('2', "abc");
        alphabet.put('3', "def");
        alphabet.put('4', "ghi");
        alphabet.put('5', "jkl");
        alphabet.put('6', "mno");
        alphabet.put('7', "pqrs");
        alphabet.put('8', "tuv");
        alphabet.put('9', "wxyz");
        ans = new ArrayList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        dfs(0, "");
        return ans;
    }

    public void dfs(int pos, String str) {
        if (pos == digits.length()) {
            ans.add(str);
            return;
        }
        String letters = alphabet.get(digits.charAt(pos));
        for (int i = 0; i < letters.length(); i++) {
            dfs(pos + 1, str + letters.charAt(i));
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}
