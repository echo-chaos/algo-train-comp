package org.lql.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: lql
 * @date: 2022/1/10 22:29
 * @description: 210. 课程表 II <a href="https://leetcode-cn.com/problems/course-schedule-ii/">...</a>
 */
public class FindOrder {

    /**
     * 现在你总共有 numCourses 门课需要选，记为0到numCourses - 1。给你一个数组prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修bi 。
     * <p>
     * 例如，想要学习课程 0 ，你需要先完成课程1 ，我们用一个匹配来表示：[0,1] 。
     * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
     * <p>
     * 示例:
     * 输入：numCourses = 2, prerequisites = [[1,0]]
     * 输出：[0,1]
     * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
     * <p>
     * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
     * 输出：[0,2,1,3]
     * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
     * 因此，一个正确的课程顺序是[0,1,2,3] 。另一个正确的排序是[0,2,1,3] 。
     * <p>
     * 输入：numCourses = 1, prerequisites = []
     * 输出：[0]
     * <p>
     * 提示:
     * 1 <= numCourses <= 2000
     * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
     * prerequisites[i].length == 2
     * 0 <= ai, bi < numCourses
     * ai != bi
     * 所有[ai, bi] 互不相同
     */

    // 出边数组
    public List<List<Integer>> to;
    // 节点的度
    int[] inDegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 初始化
        to = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            to.add(new ArrayList<>());
        }
        inDegree = new int[numCourses];
        // 出边数据
        for (int[] pre : prerequisites) {
            // 同一条边上的数据，两门课程
            int ai = pre[0];
            int bi = pre[1];
            // 出边数组
            to.get(bi).add(ai);
            // 节点的度：学习课程之前需要学习别的课程的数量
            inDegree[ai]++;
        }
        // 广搜：队列
        Queue<Integer> queue = new LinkedList<>();
        // 学过的课程
        List<Integer> lesson = new ArrayList<>();
        // 找到0度点：可以直接学习的课程
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            lesson.add(x);
            // 扩展一个点，周围可访问的点的度-1
            for (Integer y : to.get(x)) {
                inDegree[y]--;
                // 入度为0，表示可以学习该课程
                if (inDegree[y] == 0) {
                    queue.offer(y);
                }
            }
        }
        // 先判断是否完成所有课程学习，再返回学习路径
        if (lesson.size() == numCourses) {
            int[] ans = new int[lesson.size()];
            for (int i = 0; i < lesson.size(); i++) {
                ans[i] = lesson.get(i);
            }
            return ans;
        } else {
            return new int[]{};
        }
    }

    public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        System.out.println(Arrays.toString(findOrder.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
        System.out.println(Arrays.toString(findOrder.findOrder(3, new int[][]{{1, 0}, {1, 2}, {0, 1}})));
    }
}
