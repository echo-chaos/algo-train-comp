package org.lql.week09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/28 1:57 AM
 * @description: 242. 有效的字母异位词 https://leetcode-cn.com/problems/valid-anagram/
 */
public class IsAnagram {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
     * <p>
     * 1 <= s.length, t.length <= 5 * 104
     * s 和 t 仅包含小写字母
     */
    public boolean isAnagram(String s, String t) {
        // 长度不等便不是异位词
        if (s.length() != t.length()){
            return false;
        }
        // 记录s的词频
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 比对t的词频
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            // 消消乐
            map.put(c,map.getOrDefault(c,0)-1);
            if (map.get(c) < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsAnagram isAnagram = new IsAnagram();
        boolean anagram = isAnagram.isAnagram("anagram", "nagaram");
        System.out.println(anagram);
    }
}
