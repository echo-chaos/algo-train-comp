package org.lql.hot100.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 16:45
 * @description: 131. 分割回文串 <a href="https://leetcode.cn/problems/palindrome-partitioning/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Partition {

    /**
     * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是
     * 回文串
     * 。返回 s 所有可能的分割方案。
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "aab"
     * 输出：[["a","a","b"],["aa","b"]]
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "a"
     * 输出：[["a"]]
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 16
     * s 仅由小写英文字母组成
     */
    private String s;
    private final List<String> str = new ArrayList<>();
    private final List<List<String>> ans = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return ans;
        }
        this.s = s;
        recur(0);
        return ans;
    }

    public void recur(int pos) {
        if (pos == s.length()) {
            ans.add(new ArrayList<>(str));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            if (isPalindrome(pos, i)) {
                str.add(s.substring(pos, i + 1));
                recur(i + 1);
                str.remove(str.size() - 1);
            }
        }
    }

    public boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Partition partition = new Partition();
        System.out.println(partition.partition("aab"));
    }
}
