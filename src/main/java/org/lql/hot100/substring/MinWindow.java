package org.lql.hot100.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-22 15:33
 * @description: 76. 最小覆盖子串 <a href="https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MinWindow {

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     * 注意：
     * <p>
     * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
     * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     * 示例 3:
     * <p>
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
     * <p>
     * 提示：
     * <p>
     * m == s.length
     * n == t.length
     * 1 <= m, n <= 105
     * s 和 t 由英文字母组成
     */
    public String minWindow(String s, String t) {
        // 用来统计目标字符串每个字符的频率
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 统计当前窗口中每个字符出现的次数
        Map<Character, Integer> window = new HashMap<>();
        // 滑动窗口的边界
        int left = 0, right = 0;
        // 记录满足条件的字符
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, minLen = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 更新数据
            if (need.containsKey(c)) {
                // 移入窗口，更新窗口数据
                window.put(c, window.getOrDefault(c, 0) + 1);
                // 判断窗口中该字符是否满足条件
                if (window.get(c).intValue() == need.get(c).intValue()) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < minLen) {
                    start = left;
                    minLen = right - left;
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 更新数据
                if (need.containsKey(d)) {
                    if (window.get(d).intValue() == need.get(d).intValue()) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        // 返回最小覆盖子串
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow.minWindow("a", "a"));
        System.out.println(minWindow.minWindow("a", "aa"));
    }
}
