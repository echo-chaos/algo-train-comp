package org.lql.hot100.dynamicProgrammingMulti;

/**
 * @author: liangqinglong
 * @date: 2024-06-03 17:27
 * @description: 72. 编辑距离 <a href="https://leetcode.cn/problems/edit-distance/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MinDistance {

    /**
     * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * 示例 1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * <p>
     * 示例 2：
     * <p>
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // 初始化动态规划数组，dp[i][j]表示word1的前i个字符转换成word2的前j个字符所需的最小操作次数
        int[][] dp = new int[m + 1][n + 1];
        // 边界条件初始化：当其中一个字符串为空时，需要的操作次数等于另一个字符串的长度
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当两个字符相等时，不需要操作，直接继承前一个位置的最小操作次数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 当两个字符不相等时，考虑插入、删除和替换三种操作，选择最小的操作次数
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        System.out.println(minDistance.minDistance("horse", "ros"));
        System.out.println(minDistance.minDistance("intention", "execution"));
    }
}
