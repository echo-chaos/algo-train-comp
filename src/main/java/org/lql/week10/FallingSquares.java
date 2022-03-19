package org.lql.week10;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/3/17 21:24
 * @description: 699. 掉落的方块 https://leetcode-cn.com/problems/falling-squares/
 */
public class FallingSquares {

    /**
     * 在无限长的数轴（即 x 轴）上，我们根据给定的顺序放置对应的正方形方块。
     * <p>
     * 第 i 个掉落的方块（positions[i] = (left, side_length)）是正方形，
     * 其中left 表示该方块最左边的点位置(positions[i][0])，side_length 表示该方块的边长(positions[i][1])。
     * <p>
     * 每个方块的底部边缘平行于数轴（即 x 轴），
     * 并且从一个比目前所有的落地方块更高的高度掉落而下。在上一个方块结束掉落，并保持静止后，才开始掉落新方块。
     * <p>
     * 方块的底边具有非常大的粘性，并将保持固定在它们所接触的任何长度表面上（无论是数轴还是其他方块）。
     * 邻接掉落的边不会过早地粘合在一起，因为只有底边才具有粘性。
     * <p>
     * 返回一个堆叠高度列表ans 。
     * 每一个堆叠高度ans[i]表示在通过positions[0], positions[1], ..., positions[i]表示的方块掉落结束后，
     * 目前所有已经落稳的方块堆叠的最高高度。
     * <p>
     * 1 <= positions.length <= 1000.
     * 1 <= positions[i][0] <= 10^8.
     * 1 <= positions[i][1] <= 10^6.
     */
    public List<Integer> fallingSquares(int[][] positions) {
        return new ArrayList<>();
    }
}
