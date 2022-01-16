package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/1/16 15:57
 * @description: 207. 课程表  https://leetcode-cn.com/problems/course-schedule/
 */
public class CanFinish {

    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        boolean b = canFinish.canFinish(numCourses, prerequisites);
        System.out.println(b);
    }

}
