package org.lql.practice.week02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:32
 * @description: 874. 模拟行走机器人 https://leetcode-cn.com/problems/walking-robot-simulation/
 */
public class RobotSim {

    /**
     * 机器人在一个无限大小的 XY 网格平面上行走，从点(0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
     * <p>
     * -2 ：向左转90 度
     * -1 ：向右转 90 度
     * 1 <= x <= 9 ：向前移动x个单位长度
     * 在网格上有一些格子被视为障碍物obstacles 。第 i个障碍物位于网格点 obstacles[i] = (xi, yi) 。
     * <p>
     * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
     * <p>
     * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
     * <p>
     * 北表示 +Y 方向。
     * 东表示 +X 方向。
     * 南表示 -Y 方向。
     * 西表示 -X 方向。
     */
    private static final Logger logger = LoggerFactory.getLogger(RobotSim.class);

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Long, Long> obs = new HashMap<>();
        for (int[] obstacle : obstacles) {
            obs.put(calHash(obstacle), 0L);
        }
        int x = 0;
        int y = 0;
        // N-0 E-1 S-2 W-3
        int dir = 0;
        // 方向数组
        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {1, 0, -1, 0};
        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir - 1 + 4) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + directionX[dir];
                    int ny = y + directionY[dir];
                    if (obs.containsKey(calHash(new int[]{nx, ny}))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                }
            }
            ans = Math.max(ans, x * x + y * y);
        }
        return ans;
    }

    private Long calHash(int[] obstacle) {
        // 行号 * 列数 + 列号
        return (obstacle[0] + 30000) * 60001L + (obstacle[1] + 30000);
    }

    public static void main(String[] args) {
        RobotSim robotSim = new RobotSim();
        int[] commands = {4, -1, 4, -2, 4};
        int[][] obstacles = {{2, 4}};
        int sim = robotSim.robotSim(commands, obstacles);
        System.out.println(sim);
    }
}
