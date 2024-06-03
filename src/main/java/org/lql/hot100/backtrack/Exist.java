package org.lql.hot100.backtrack;

/**
 * @author: liangqinglong
 * @date: 2024-05-30 16:10
 * @description: 79. 单词搜索 <a href="https://leetcode.cn/problems/word-search/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Exist {

    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     */
    private int m, n;
    private char[][] board;
    private String word;
    private final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        this.board = board;
        this.word = word;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int sx, int sy, int pos) {
        // 边界检查
        if (sx < 0 || sx >= m || sy < 0 || sy >= n) {
            return false;
        }
        // 检查当前位置是否已访问过，或者当前字符是否匹配
        if (visited[sx][sy] || board[sx][sy] != word.charAt(pos)) {
            return false;
        }
        // 如果已经找到了整个单词，返回true
        if (pos == word.length() - 1) {
            return true;
        }
        visited[sx][sy] = true;
        for (int[] direction : directions) {
            int nx = sx + direction[0];
            int ny = sy + direction[1];
            // 使用DFS递归搜索下一个字符
            if (dfs(nx, ny, pos + 1)) {
                return true;
            }
        }
        visited[sx][sy] = false;
        return false;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        Exist exist = new Exist();
        System.out.println(exist.exist(board, word));

        System.out.println(exist.exist(new char[][]{{'a'}}, "a"));
        System.out.println(exist.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "acdb"));
        System.out.println(exist.exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "abcd"));
    }
}
