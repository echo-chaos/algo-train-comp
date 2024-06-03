package org.lql.hot100.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-21 20:33
 * @description: 438. 找到字符串中所有字母异位词 <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class FindAnagrams {

    /**
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "cbaebabacd", p = "abc"
     * 输出: [0,6]
     * 解释:
     * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
     * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
     * 示例 2:
     * <p>
     * 输入: s = "abab", p = "ab"
     * 输出: [0,1,2]
     * 解释:
     * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
     * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
     * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
     * <p>
     * 提示:
     * <p>
     * 1 <= s.length, p.length <= 3 * 104
     * s 和 p 仅包含小写字母
     */
    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return new ArrayList<>();
        }
        // s&p 的词频
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < n; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        List<Integer> ans = new ArrayList<Integer>();
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }
        for (int i = 0; i < m - n; i++) {
            // 窗口左边界字符移除
            sCount[s.charAt(i) - 'a']--;
            // 窗口右边界字符添加
            sCount[s.charAt(i + n) - 'a']++;
            // 判断是否相等
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        System.out.println(findAnagrams.findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams.findAnagrams("abab", "ab"));
    }
}
