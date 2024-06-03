package org.lql.hot100.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: liangqinglong
 * @date: 2024-05-23 14:47
 * @description: 56. 合并区间 <a href="https://leetcode.cn/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Merge {

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * <p>
     * 提示：
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     */
    public int[][] merge(int[][] intervals) {
        // 对区间数组进行排序
        Arrays.sort(intervals, Comparator.<int[]>comparingInt(a -> a[0]).thenComparing(a -> a[1]));
        List<int[]> ans = new ArrayList<>();
        // 最远的距离
        int farthest = -1;
        // 开始距离
        int start = -1;
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            // 如果左小于最远距离，说明有重叠，更新最远距离
            if (left <= farthest) {
                // 更新最远距离，farthest与right取较大值
                farthest = Math.max(farthest, right);
            } else {
                // 没有重叠，将上一个区间添加到结果中
                if (farthest != -1) {
                    ans.add(new int[]{start, farthest});
                }
                // 开始一个新区间
                start = left;
                farthest = right;
            }
        }
        ans.add(new int[]{start, farthest});
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        // [[1,6],[8,10],[15,18]]
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        // [[1,5]]
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 4}, {4, 5}})));
        // [[0,4]]
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 4}, {0, 4}})));
    }
}
