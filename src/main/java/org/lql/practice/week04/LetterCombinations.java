package org.lql.practice.week04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/13 20:45
 * @description: 17. 电话号码的字母组合 <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">...</a>
 */
public class LetterCombinations {

    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
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

    /**
     *
     * @param index 按下的数字 digits内的
     * @param str 数字对应的字符，映射范围内的
     */
    private void dfs(int index, String str) {
        if (index == digits.length()) {
            ans.add(str);
            return;
        }
        for (char ch : alphabet.get(digits.charAt(index)).toCharArray()) {
            dfs(index + 1, str + ch);
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}
