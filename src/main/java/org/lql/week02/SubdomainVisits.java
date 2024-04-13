package org.lql.week02;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/3 22:42
 * @description: 811. 子域名访问计数 <a href="https://leetcode-cn.com/problems/subdomain-visit-count/">...</a>
 */
public class SubdomainVisits {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>(cpdomains.length * 3);
        for (String str : cpdomains) {
            // 分割访问数和网站域名
            String[] split = str.split(" ");
            // 访问数
            int num = Integer.parseInt(split[0]);
            // 域名再按照.分割出子域名
            String[] mains = split[1].split("\\.");
            String temp = "";
            // 逆序能够将子域名包含到更上一级的域名中
            for (int i = mains.length - 1; i >= 0; i--) {
                temp = mains[i] + (i < mains.length - 1 ? "." : "") + temp;
                map.put(temp, map.getOrDefault(temp, 0) + num);
            }
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            list.add(map.get(key) + " " + key);
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
