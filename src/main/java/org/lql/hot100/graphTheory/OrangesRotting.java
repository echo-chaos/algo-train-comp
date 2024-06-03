package org.lql.hot100.graphTheory;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 16:54
 * @description: 994. 腐烂的橘子 <a href="https://leetcode.cn/problems/rotting-oranges/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class OrangesRotting {

    /**
     * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
     * <p>
     * 值 0 代表空单元格；
     * <p>
     * 值 1 代表新鲜橘子；
     * <p>
     * 值 2 代表腐烂的橘子。
     * <p>
     * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
     * <p>
     * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
     * 输出：4
     * <p>
     * 示例 2：
     * <p>
     * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
     * 输出：-1
     * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
     * <p>
     * 示例 3：
     * <p>
     * 输入：grid = [[0,2]]
     * 输出：0
     * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
     */
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int[][] grid;
    private static int row;
    private static int col;
    private static int freshCount;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        this.grid = grid;
        row = grid.length;
        col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        freshCount = 0;
        // 初始化队列和新鲜橘子的数量
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        // 分钟数
        int minutes = 0;
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                spreadRottingOranges(queue, x, y);
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }

    private void spreadRottingOranges(Queue<int[]> queue, int sx, int sy) {
        for (int[] direction : directions) {
            int nx = sx + direction[0];
            int ny = sy + direction[1];
            // 检查相邻橘子是否在范围内且为新鲜橘子，如果是则将其腐烂并加入队列
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && grid[nx][ny] == 1) {
                // 标记为腐烂
                grid[nx][ny] = 2;
                // 加入队列以继续腐烂
                queue.offer(new int[]{nx, ny});
                // 更新新鲜橘子数量
                freshCount--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        OrangesRotting orangesRotting = new OrangesRotting();
        int result = orangesRotting.orangesRotting(grid);
        System.out.println(result);
    }
}
