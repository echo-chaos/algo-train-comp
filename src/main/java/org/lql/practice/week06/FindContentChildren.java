package org.lql.practice.week06;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/13 22:06
 * @description: 455. 分发饼干 https://leetcode-cn.com/problems/assign-cookies/description/
 */
public class FindContentChildren {

    /**
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * <p>
     * 对每个孩子 i，都有一个胃口值g[i]，
     * 这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，
     * 都有一个尺寸 s[j]。如果 s[j]>= g[i]，
     * 我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * <p>
     * 1 <= g.length <= 3 * 104
     * 0 <= s.length <= 3 * 104
     * 1 <= g[i], s[j] <= 231 - 1
     */
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        // 排序孩子的胃口以及饼干的尺寸
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0;
        for (int child : g) {
            // 根据孩子的胃口寻找与胃口相近的饼干尺寸
            while (j < s.length && s[j] < child) {
                j++;
            }
            // 因为孩子的胃口以及饼干的尺寸已经经过排序，所以
            if (j < s.length) {
                ans++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindContentChildren findContentChildren = new FindContentChildren();
        int[] g = {1, 2, 3, 5};
        int[] s = {1, 4, 1, 3};
        int contentChildren = findContentChildren.findContentChildren(g, s);
        System.out.println(contentChildren);
    }
}
