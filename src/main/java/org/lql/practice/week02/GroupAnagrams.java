package org.lql.practice.week02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/3 22:33
 * @description: 49. 字母异位词分组 <a href="https://leetcode-cn.com/problems/group-anagrams/">...</a>
 */
public class GroupAnagrams {

    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * <p>
     * 示例 1:
     * <p>
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 示例 2:
     * <p>
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     * <p>
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     */

    private static final Logger logger = LoggerFactory.getLogger(GroupAnagrams.class);

    public List<List<String>> groupAnagrams(String[] strs) {
        // 对字母异位词进行分组
        Map<String, List<String>> groups = new HashMap<>(strs.length);
        for (String str : strs) {
            // 对字母异位词进行排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 排序后的字母异位词作为key
            String key = new String(charArray);
            // 判断字母异位词是否存在
            if (!groups.containsKey(key)) {
                // 不存在就建立一个空的List，用来存放全部的字母异位词
                groups.put(key, new ArrayList<>());
            }
            // 将对应的字母异位词放入同一个List
            groups.get(key).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = anagrams.groupAnagrams(strs);
        logger.info("lists -> {}", lists);
        logger.info("[\"\"] -> {}", anagrams.groupAnagrams(new String[]{""}));
        logger.info("[\"a\"] -> {}", anagrams.groupAnagrams(new String[]{"a"}));
    }
}
