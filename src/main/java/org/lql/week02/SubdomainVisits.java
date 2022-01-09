package org.lql.week02;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/3 22:42
 * @description: 811. 子域名访问计数 https://leetcode-cn.com/problems/subdomain-visit-count/
 */
public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>(cpdomains.length * 3);
        for (String str : cpdomains) {
            String[] split = str.split(" ");
            int num = Integer.parseInt(split[0]);
            String[] mains = split[1].split("\\.");
            String temp = "";
            for (int i = mains.length - 1; i >= 0; i--) {
                temp = mains[i] + (i < mains.length - 1 ? "." : "") + temp;
                map.put(temp, map.getOrDefault(temp, 0) + num);
            }
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add("" + map.get(key) + " " + key);
        }
        return list;
    }

    public static void main(String[] args) {
        SubdomainVisits visits = new SubdomainVisits();
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> list = visits.subdomainVisits(cpdomains);
        System.out.println(list);
    }
}
