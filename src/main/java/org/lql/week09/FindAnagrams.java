package org.lql.week09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/28 1:59 AM
 * @description: 438. 找到字符串中所有字母异位词 https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAnagrams {

    /**
     * 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
     * <p>
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
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
        /**
         * s: cbaebabacd m [1,1,1,0,0,0,0,0,0,...]
         * p: abc        n [1,1,1,0,0,0,0,0,0,...]
         *      c b a e b a b a c d
         * i:   0          m-n
         * i+n:     n             i+n
         */
        for (int i = 0; i < m - n; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + n) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> anagrams = findAnagrams.findAnagrams("cbaebabacd", "abc");
        System.out.println(Collections.unmodifiableList(anagrams));
    }
}
