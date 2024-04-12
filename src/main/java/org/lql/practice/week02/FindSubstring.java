package org.lql.practice.week02;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/3 22:34
 * @description: 30. 串联所有单词的子串 <a href="https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/">...</a>
 */
public class FindSubstring {

    /**
     * 给定一个字符串s和一些 长度相同 的单词words 。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
     * <p>
     * 注意子串要与words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑words中单词串联的顺序。
     * <p>
     * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * <p>
     * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
     * 输出：[]
     * <p>
     * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
     * 输出：[6,9,12]
     * <p>
     * 1 <= s.length <= 104
     * s 由小写英文字母组成
     * 1 <= words.length <= 5000
     * 1 <= words[i].length <= 30
     * words[i]由小写英文字母组成
     */

    Map<String, Integer> wordsMap = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {
        // 总的单词长度
        int tot = 0;
        for (String word : words) {
            tot += word.length();
            // 将words中的单词和出现次数写到wordsMap中
            if (wordsMap.containsKey(word)) {
                wordsMap.put(word, wordsMap.get(word) + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        List<Integer> ans = new ArrayList<>();
        // 按照单词长度分隔字符
        for (int i = 0; i + tot <= s.length(); i++) {
            // 按照总的单词长度切割字符串，并与words进行比较
            String substring = s.substring(i, i + tot);
            if (valid(substring, words)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private boolean valid(String str, String[] words) {
        int k = words[0].length();
        Map<String, Integer> splitWordsMap = new HashMap<>();
        for (int i = 0; i < str.length(); i += k) {
            String key = str.substring(i, i + k);
            if (splitWordsMap.containsKey(key)) {
                Integer integer = splitWordsMap.get(key);
                splitWordsMap.put(key, ++integer);
            } else {
                splitWordsMap.put(key, 1);
            }
        }
        return compareMaps(splitWordsMap, wordsMap);
    }

    private boolean compareMaps(Map<String, Integer> splitMap, Map<String, Integer> wordsMap) {
        boolean flag = true;
        for (String key : splitMap.keySet()) {
            Integer value = splitMap.get(key);
            if (!wordsMap.containsKey(key) || !wordsMap.get(key).equals(value)) {
                flag = false;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","word"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar", "foo", "the"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word", "good", "best", "good"};
        String s = "bcabbcaabbccacacbabccacaababcbb";           //[3,4,6,16,17,18,19,20]
        String[] words = {"c", "b", "a", "c", "a", "a", "a", "b", "c"}; //[6,16,17,18,19,20]
        List<Integer> substring = findSubstring.findSubstring(s, words);
        System.out.println(substring);
    }
}