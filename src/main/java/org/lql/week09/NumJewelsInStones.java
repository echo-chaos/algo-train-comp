package org.lql.week09;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: lql
 * @date: 2022/2/28 1:50 AM
 * @description: 771. 宝石与石头 https://leetcode-cn.com/problems/jewels-and-stones/
 */
public class NumJewelsInStones {

    /**
     * 给你一个字符串 jewels代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
     * stones中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
     * <p>
     * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
     * <p>
     * 1 <=jewels.length, stones.length <= 50
     * jewels 和 stones 仅由英文字母组成
     * jewels 中的所有字符都是 唯一的
     */
    public int numJewelsInStones(String jewels, String stones) {
        int ans = 0;
        Set<Character> jewelsSet = new HashSet<Character>();
        for (int i = 0; i < jewels.length(); i++) {
            char jewel = jewels.charAt(i);
            jewelsSet.add(jewel);
        }
        for (int i = 0; i < stones.length(); i++) {
            char stone = stones.charAt(i);
            if (jewelsSet.contains(stone)) {
                ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        NumJewelsInStones stones = new NumJewelsInStones();
        int i = stones.numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }
}
