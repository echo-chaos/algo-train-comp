package org.lql.practice.week05;

import org.lql.common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/13 21:21
 * @description: 56. 合并区间 <a href="https://leetcode-cn.com/problems/merge-intervals/">...</a>
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
        // 排序
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

    public int[][] mergeBy(int[][] intervals) {
        List<Pair<Integer, Integer>> events = new ArrayList<>();
        // 区间做差分
        for (int[] interval : intervals) {
            events.add(new Pair<>(interval[0], 1));
            events.add(new Pair<>(interval[1] + 1, -1));
        }
        // 二元祖排序
        events.sort(Comparator.<Pair<Integer, Integer>>comparingInt(Pair::getKey).thenComparing(Pair::getValue));
        // 当前的覆盖次数
        int covering = 0;
        int start = -1;
        List<int[]> ans = new ArrayList<>();
        for (Pair<Integer, Integer> event : events) {
            // 开始覆盖从0开始
            if (covering == 0) {
                start = event.getKey();
            }
            // 进行覆盖
            covering += event.getValue();
            // 停止覆盖，即完成一次完整区间覆盖，记录一次区间
            if (covering == 0) {
                // 差分的时候，需要减去1
                ans.add(new int[]{start, event.getKey() - 1});
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        Merge merge = new Merge();
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge.mergeBy(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(merge.merge(new int[][]{{1, 4}, {0, 0}})));
        System.out.println(Arrays.deepToString(merge.mergeBy(new int[][]{{1, 4}, {0, 0}})));
    }
}
