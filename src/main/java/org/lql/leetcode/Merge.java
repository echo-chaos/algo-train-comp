package org.lql.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/8 10:13
 * @description: 56. 合并区间 https://leetcode-cn.com/problems/merge-intervals/
 */
public class Merge {

    /**
     * 以数组 intervals 表示若干个区间的集合，
     * 其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * <p>
     * 1 <= intervals.length <= 104
     * intervals[i].length == 2
     * 0 <= starti <= endi <= 104
     */

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> merged = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            int l = interval[0];
            int r = interval[1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < l) {
                merged.add(new int[]{l, r});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], r);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge1 = merge.merge(intervals);
        System.out.println(Arrays.deepToString(merge1));
    }
}
