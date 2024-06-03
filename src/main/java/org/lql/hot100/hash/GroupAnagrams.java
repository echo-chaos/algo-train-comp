package org.lql.hot100.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-20 20:50
 * @description: 49. 字母异位词分组 <a href="https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class GroupAnagrams {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
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
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            // 对字母异位词进行重新排序
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            // 作为分组的依据
            String key = new String(charArray);
            // 判断异位词是否已存在
            if (!groups.containsKey(key)) {
                // 不存在，新建异位词的分组
                groups.put(key, new ArrayList<>());
            }
            // 将异位词放入对应的分组内
            groups.get(key).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams.groupAnagrams(new String[]{"a"}));
    }
}
