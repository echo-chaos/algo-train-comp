package org.lql.week09;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/28 1:52 AM
 * @description: 387. 字符串中的第一个唯一字符 https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqChar {

    /**
     * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
     * <p>
     * 1 <= s.length <= 105
     * s 只包含小写字母
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        int leetcode = firstUniqChar.firstUniqChar("leetcode");
        System.out.println(leetcode);
    }
}
