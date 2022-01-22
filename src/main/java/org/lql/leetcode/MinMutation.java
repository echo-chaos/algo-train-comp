package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/21 17:30
 * @description: 433. 最小基因变化 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinMutation {

    HashSet<String> hashBack = new HashSet<>();
    HashMap<String, Integer> depth = new HashMap<>();

    public int minMutation(String start, String end, String[] bank) {
        depth.put(start, 0);
        hashBack.addAll(Arrays.asList(bank));
        if (!hashBack.contains(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.add(start);
        char[] gene = {'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            String poll = queue.poll();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    if (poll.charAt(i) != gene[j]) {
                        char[] chars = poll.toCharArray();
                        chars[i] = gene[j];
                        String ns = new String(chars);
                        if (!hashBack.contains(ns)) {
                            continue;
                        }
                        if (depth.containsKey(ns)) {
                            continue;
                        }
                        depth.put(ns, depth.get(poll) + 1);
                        queue.add(ns);
                        if (ns.equals(end)) {
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
        String start = "AACCGGTT";
        String end = "AACCGGTA";
        String[] bank = {"AACCGGTA"};
        int i = minMutation.minMutation(start, end, bank);
        System.out.println(i);
    }

}
