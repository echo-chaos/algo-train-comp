package org.lql.leetcode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/4 16:30
 * @description: 49. 字母异位词分组  https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    /**
     * <p>题目：</p>
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * <p>
     * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
     *
     * <p>示例 :</p>
     * <li>输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]</li>
     * <li>输出: [["bat"],["nat","tan"],["ate","eat","tea"]]</li>
     *
     * <li>输入: strs = [""]</li>
     * <li>输出: [[""]]</li>
     *
     * <li>输入: strs = ["a"]</li>
     * <li>输出: [["a"]]</li>
     *
     * <p>注意：</p>
     * <li>1 <= strs.length <= 104</li>
     * <li>0 <= strs[i].length <= 100</li>
     * <li>strs[i] 仅包含小写字母</li>
     */
    private static final Logger logger = LoggerFactory.getLogger(GroupAnagrams.class);


    /**
     *
     * @param strs strs
     * @return res
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            // 将异位词转换成可比较的形式
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            // 检查map中本异位词是否存在
            if (!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = anagrams.groupAnagrams(strs);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
