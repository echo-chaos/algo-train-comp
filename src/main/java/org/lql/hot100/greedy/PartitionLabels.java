package org.lql.hot100.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 23:13
 * @description: 763. 划分字母区间 <a href="https://leetcode.cn/problems/partition-labels/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class PartitionLabels {

    /**
     * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
     * <p>
     * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
     * <p>
     * 返回一个表示每个字符串片段的长度的列表。
     * <p>
     * 示例 1：
     * 输入：s = "ababcbacadefegdehijhklij"
     * 输出：[9,7,8]
     * 解释：
     * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
     * 每个字母最多出现在一个片段中。
     * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
     * <p>
     * 示例 2：
     * <p>
     * 输入：s = "eccbbbbdec"
     * 输出：[10]
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length <= 500
     * s 仅由小写英文字母组成
     */
    public List<Integer> partitionLabels(String s) {
        // last数组用于记录每个字符最后一次出现的索引位置
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            // 更新字符最后一次出现的位置：a:0, b:1, c:2, ..., z:25
            last[s.charAt(i) - 'a'] = i;
        }
        // 当前片段的起始位置, 当前片段的结束位置
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 更新当前片段的结束位置
            end = Math.max(end, last[s.charAt(i) - 'a']);
            // 如果当前索引等于当前片段的结束位置，则划分片段并更新起始位置
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels = new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
        System.out.println(partitionLabels.partitionLabels("eccbbbbdec"));
    }
}
