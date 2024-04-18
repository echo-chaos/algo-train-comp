package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: lql
 * @date: 2022/2/13 20:35
 * @description: 207. 课程表 <a href="https://leetcode-cn.com/problems/course-schedule/">...</a>
 */
public class CanFinish {

    /**
     * 你这个学期必须选修 numCourses 门课程，记为0到numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组prerequisites 给出，其中prerequisites[i] = [ai, bi] ，表示如果要学习课程ai 则 必须 先学习课程 bi 。
     * <p>
     * 例如，先修课程对[0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     * <p>
     * 1 <= numCourses <= 105
     * 0 <= prerequisites.length <= 5000
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * prerequisites[i] 中的所有课程对 互不相同
     */

    // 出边数组
    public List<List<Integer>> to;
    // 节点的度
    int[] inDegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 初始化
        to = new ArrayList<>();
        inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            to.add(new ArrayList<>());
        }
        // 出边数组数据
        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            to.get(bi).add(ai);
            inDegree[ai]++;
        }
        // 广搜队列：存放可以学习的课程
        Queue<Integer> queue = new LinkedList<>();
        // 学习过的课程
        List<Integer> lesson = new ArrayList<>();
        // 拓扑排序第一步：从零入读的点出发
        // 即：寻找某一门可以直接学习的课程，开始学习
        for (int i = 0; i < numCourses; i++) {
            // 节点的度为0，表示可以直接学习的课程
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            lesson.add(x);
            // 拓扑排序第二步：扩展一个点，周围的点入读减一
            for (Integer y : to.get(x)) {
                inDegree[y]--;
                // 拓扑排序第三步：入读减为0，表示可以入队=>可以进行学习
                if (inDegree[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        return lesson.size() == numCourses;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        int numCourses = 2;
        int[][] prerequisites = new int[][]{{1, 0}};
        System.out.println(canFinish.canFinish(numCourses, prerequisites));
    }
}
