package org.lql.hot100.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-21 20:10
 * @description: 3. 无重复字符的最长子串 <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LengthOfLongestSubstring {

    /**
     * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * <p>
     * 提示：
     * <p>
     * 0 <= s.length <= 5 * 104
     * s 由英文字母、数字、符号和空格组成
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        // 使用HashMap来存储字符和其在当前窗口中的最后出现位置
        Map<Character, Integer> map = new HashMap<>();
        // 最长子串的长度
        int length = 0;
        // 窗口的起始位置
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // 如果字符已经出现过，更新窗口的起始位置
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            // 更新字符的最后出现位置
            map.put(currentChar, i);
            // 更新最长子串的长度
            length = Math.max(length, i - start + 1);
        }
        return length;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        // 3
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        // 1
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb"));
        // 3
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
    }
}
