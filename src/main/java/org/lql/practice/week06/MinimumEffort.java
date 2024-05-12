package org.lql.practice.week06;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/2/13 22:10
 * @description: 1665. 完成所有任务的最少初始能量 <a href="https://leetcode-cn.com/problems/minimum-initial-energy-to-finish-tasks/">...</a>
 */
public class MinimumEffort {

    /**
     * 给你一个任务数组tasks ，其中tasks[i] = [actuali, minimumi]：
     * <p>
     * actuali是完成第 i个任务 需要耗费的实际能量。
     * minimumi是开始第 i个任务前需要达到的最低能量。
     * 比方说，如果任务为[10, 12]且你当前的能量为11，
     * 那么你不能开始这个任务。如果你当前的能量为13，
     * 你可以完成这个任务，且完成它后剩余能量为 3。
     * <p>
     * 你可以按照 任意顺序完成任务。
     * <p>
     * 请你返回完成所有任务的 最少初始能量。
     * <p>
     * 1 <= tasks.length <= 105
     * 1 <= actual​i <= minimumi <= 104
     */
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[0] - a[1] - (b[0] - b[1]));
        int ans = 0;
        for (int i = tasks.length - 1; i >= 0; i--) {
            ans = Math.max(tasks[i][1], ans + tasks[i][0]);
        }
        return ans;
    }

    public static void main(String[] args) {
        // 输出：8
        System.out.println(new MinimumEffort().minimumEffort(new int[][]{{1, 2}, {2, 4}, {4, 8}}));
        // 输出：32
        System.out.println(new MinimumEffort().minimumEffort(new int[][]{{1, 3}, {2, 4}, {10, 11}, {10, 12}, {8, 9}}));
        // 输出：27
        System.out.println(new MinimumEffort().minimumEffort(new int[][]{{1, 7}, {2, 8}, {3, 9}, {4, 10}, {5, 11}, {6, 12}}));
    }
}
