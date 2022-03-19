package org.lql.examination;

import java.util.Scanner;

/**
 * @author: lql
 * @date: 2022/3/17 16:05
 * @description: 期末2
 */
public class ET2BuildHouse {

    /**
     * 你准备在一座山脚下盖房子定居。盖房子需要钢材,
     * 幸运的是,这里有排成一行的n座废弃的铁塔,从左到右编号为1~n,其中第座铁塔可以提供h[i]单位的钢材。
     * 你需要把这些铁塔从左至右分成若干组,每组内的铁塔编号必须是连续的,并且从左至右每一组铁塔的能提供的钢材总量单调不减。
     * <p>
     * 最后,你可以用每组铁塔所提供的钢材构成一层上面小下面大的城堡。
     * 负责处理钢材和建造城堡的公司对每一座铁塔收取 1 金币的费用,但会给每一层城堡(即每一组钢材)优惠 1 金币。
     * 这样一来你要交的费用就是 n-组数 枚金币。因此你需要把这些铁塔分成尽量多组
     * 例如有8座铁塔,高度分别为 1,9,9,4,1,2,2,9。
     * 你最多把它们分成5组连续的铁塔:1、9、9、4+1+2+2、9,
     * 每组提供的钢材总量为1、9、9、9、9,单调不减。
     * 费用为8-5=3枚金币。
     * <p>
     * 输入
     * 第一行一个整数 n。
     * 第二行n个用空格隔开的数,第i个整数表示h。
     * 输出输出一个整数,表示最少付出的金币数,即(n-最多能分成的组数)。
     * <p>
     * 样例输入:
     * 8
     * 1 9 9 4 1 2 2 9
     * 样例输出:
     * 3
     * <p>
     * 0 < n ≤ 200000，0 < h[ i ] ≤ 2147483647
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int MAX = 5000;
        long[] tower = new long[MAX];
        long[] sum = new long[MAX];
        long[] dp = new long[MAX];
        long[] last = new long[MAX];
        // 🗼
        for (int i = 0; i < n; i++) {
            tower[i] = scanner.nextInt();
        }
        // 前缀和
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + tower[i - 1];
        }
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (sum[i] - sum[j] >= last[j]) {
                    dp[i] = dp[j] + 1;
                    last[i] = sum[i] - sum[j];
                }
            }
        }
        System.out.println(n - dp[n]);
    }
}
