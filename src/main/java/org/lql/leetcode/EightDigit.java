package org.lql.leetcode;

import java.util.*;

/**
 * @author: lql
 * @date: 2022/3/6 23:24
 * @description: 845. 八数码 https://www.acwing.com/problem/content/847/
 */
public class EightDigit {

    /**
     * 在一个 3×3的网格中，1∼8这 8个数字和一个 x 恰好不重不漏地分布在这 3×3的网格中。
     * <p>
     * 例如：
     * <p>
     * 1 2 3
     * x 4 6
     * 7 5 8
     * 在游戏过程中，可以把 x 与其上、下、左、右四个方向之一的数字交换（如果存在）。
     * <p>
     * 我们的目的是通过交换，使得网格变为如下排列（称为正确排列）：
     * <p>
     * 1 2 3
     * 4 5 6
     * 7 8 x
     * 例如，示例中图形就可以通过让 x 先后与右、下、右三个方向的数字交换成功得到正确排列。
     * <p>
     * 交换过程如下：
     * <p>
     * 1 2 3   1 2 3   1 2 3   1 2 3
     * x 4 6   4 x 6   4 5 6   4 5 6
     * 7 5 8   7 5 8   7 x 8   7 8 x
     * 现在，给你一个初始网格，请你求出得到正确排列至少需要进行多少次交换。
     * <p>
     * 输入格式：输入占一行，将 3×3的初始网格描绘出来。
     * <p>
     * 例如，如果初始网格如下所示：
     * <p>
     * 1 2 3
     * x 4 6
     * 7 5 8
     * 则输入为：1 2 3 x 4 6 7 5 8
     * <p>
     * 输出格式：输出占一行，包含一个整数，表示最少交换次数。
     * <p>
     * 如果不存在解决方案，则输出 −1。
     * <p>
     * 输入样例：2  3  4  1  5  x  7  6  8
     * 输出样例：19
     */
    public static void main(String[] args) {
        int[][] digit = new int[3][3];
        String initial = "";
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String value = scanner.next();
            initial += value;
            if ("x".equals(value)) {
                value = "0";
            }
            digit[i / 3][i % 3] = Integer.parseInt(value);
        }
        String target = "12345678x";
        int ans = bfs(initial,target);
        System.out.println(ans);
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int bfs(String initial, String target) {
        Queue<String> q = new ArrayDeque<>();
        Map<String, Integer> map = new HashMap<>();
        q.offer(initial);
        map.put(initial, 0);
        // 方向数组
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            // 出队，寻找到0的位置
            String poll = q.poll();
            int z = poll.indexOf('x');
            // 计算0的坐标
            int x = z / 3;
            int y = z % 3;
            Integer index = map.get(poll);
            if (poll.equals(target)) {
                return index;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                    char[] chars = poll.toCharArray();
                    swap(chars, z, nx * 3 + ny);
                    String s = String.valueOf(chars);
                    if (!map.containsKey(s)){
                        map.put(s,map.get(poll)+1);
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
    }
}
