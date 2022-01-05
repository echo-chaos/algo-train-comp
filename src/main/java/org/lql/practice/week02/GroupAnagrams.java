package org.lql.practice.week02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/3 22:33
 * @description: 49. 字母异位词分组 https://leetcode-cn.com/problems/group-anagrams/
 */
public class GroupAnagrams {

    private static final Logger logger = LoggerFactory.getLogger(GroupAnagrams.class);

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>(strs.length);
        for (String str : strs) {
            String copy = str;
            Arrays.sort(copy.toCharArray());
            if (!groups.containsKey(copy)) {
                groups.put(copy, new ArrayList<>());
            }
            groups.get(copy).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> group : groups.values()) {
            ans.add(group);
        }
        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams anagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = anagrams.groupAnagrams(strs);
        System.out.println(Arrays.toString(lists.toArray()));
    }
}
