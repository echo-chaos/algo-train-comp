package org.lql.hot100.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-06-02 14:57
 * @description: 739. 每日温度 <a href="https://leetcode.cn/problems/daily-temperatures/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class DailyTemperatures {

    /**
     * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * <p>
     * 示例 1:
     * <p>
     * 输入: temperatures = [73,74,75,71,69,72,76,73]
     * 输出: [1,1,4,2,1,1,0,0]
     * <p>
     * 示例 2:
     * <p>
     * 输入: temperatures = [30,40,50,60]
     * 输出: [1,1,1,0]
     * <p>
     * 示例 3:
     * <p>
     * 输入: temperatures = [30,60,90]
     * 输出: [1,1,0]
     * <p>
     * 提示：
     * <p>
     * 1 <= temperatures.length <= 105
     * 30 <= temperatures[i] <= 100
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        // 单调栈: 栈中存放的是索引
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // 栈不为空，并且栈顶元素对应的温度小于当前温度
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                // 栈顶元素出栈,计算等待天数
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(temperatures)));
    }
}
