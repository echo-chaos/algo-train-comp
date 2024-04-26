package org.lql.practice.week04;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author: lql
 * @date: 2022/2/13 20:49
 * @description: 433. 最小基因变化 <a href="https://leetcode-cn.com/problems/minimum-genetic-mutation/">...</a>
 */
public class MinMutation {

    /**
     * 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
     * <p>
     * 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。
     * <p>
     * 例如，基因序列由"AACCGGTT"变化至"AACCGGTA"即发生了一次基因变化。
     * <p>
     * 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。
     * <p>
     * 现在给定3个参数 — start, end, bank，分别代表起始基因序列，
     * 目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变化次数。
     * 如果无法实现目标变化，请返回 -1。
     * <p>
     * 注意：
     * <p>
     * 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。
     * 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。
     * 假定起始基因序列与目标基因序列是不一样的。
     */
    public int minMutation(String startGen, String endGene, String[] bank) {
        // 基因序列作为点，基因变化作为边，求每次变化的深度即变化的次数
        Map<String, Integer> depth = new HashMap<>();
        // 初始基因序列深度为0
        depth.put(startGen, 0);
        // 将合法基因放进Set便于查找
        Set<String> hashBank = new HashSet<>();
        Collections.addAll(hashBank, bank);
        // 如果最终的基因本身是不合法的，直接返回-1
        if (!hashBank.contains(endGene)) {
            return -1;
        }
        // 广搜队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGen);
        // 基因的基本元素
        char[] gene = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            // 队头出队
            String s = queue.poll();
            // 基因长度为8个字符，遍历一遍每个位置上的变化
            for (int i = 0; i < 8; i++) {
                // 基因的基本元素有4个，基因每个位置上可能有4种变化
                for (int j = 0; j < 4; j++) {
                    if (s.charAt(i) != gene[j]) {
                        // 替换掉位置i上的字符，成为新的基因序列
                        // String ns = s.substring(0, i) + gene[j] + s.substring(i + 1);
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i, gene[j]);
                        String ns = sb.toString();
                        // 如果序列不合法，跳过
                        if (!hashBank.contains(ns)) {
                            continue;
                        }
                        // 如果序列已出现，跳过
                        if (depth.containsKey(ns)) {
                            continue;
                        }
                        // 基因合法，深度加1即变化次数加1
                        depth.put(ns, depth.get(s) + 1);
                        // 合法基因序列入队
                        queue.offer(ns);
                        // 如果基因序列与目标序列一致，即变化结束
                        if (ns.equals(endGene)) {
                            return depth.get(ns);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinMutation minMutation = new MinMutation();
        // 1
        System.out.println(minMutation.minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        // 2
        System.out.println(minMutation.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        // 3
        System.out.println(minMutation.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
