package org.lql.leetcode;

/**
 * @author: lql
 * @date: 2022/2/20 6:46 PM
 * @description: 72. 编辑距离  https://leetcode-cn.com/problems/edit-distance/
 */
public class MinDistance {

    /**
     * 给你两个单词word1 和word2， 请返回将word1转换成word2 所使用的最少操作数 。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * 0 <= word1.length, word2.length <= 500
     * word1 和 word2 由小写英文字母组成
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0) {
            return n + m;
        }

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }

    public static void main(String[] args) {
        MinDistance minDistance = new MinDistance();
        int i = minDistance.minDistance("intention", "execution");
        System.out.println(i);
    }
}
