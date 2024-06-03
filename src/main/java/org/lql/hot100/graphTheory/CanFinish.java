package org.lql.hot100.graphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 17:19
 * @description: 207. 课程表 <a href="https://leetcode.cn/problems/course-schedule/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class CanFinish {

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * <p>
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
     * <p>
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */
    List<List<Integer>> to;
    int[] inDegree;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            // 如果课程数小于等于0或先决条件为空，则无法进行学习。
            return false;
        }
        to = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            to.add(new ArrayList<>());
        }
        inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            // 出边数组：有方向性,学习课程的先后顺序性
            this.to.get(bi).add(ai);
            // 节点的入度：表示学习这门课程之前，需要先学习几门其他课程
            inDegree[ai]++;
        }
        // 学习的课程
        List<Integer> lessons = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer lesson = queue.poll();
            lessons.add(lesson);
            for (Integer needLesson : to.get(lesson)) {
                inDegree[needLesson]--;
                if (inDegree[needLesson] == 0) {
                    queue.offer(needLesson);
                }
            }
        }
        return lessons.size() == numCourses;
    }
}
