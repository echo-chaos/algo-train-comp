package org.lql.week05;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/7 21:47
 * @description: 911. 在线选举 https://leetcode-cn.com/problems/online-election/
 */
public class TopVotedCandidate {

    /**
     * 给你两个整数数组 persons 和 times 。
     * 在选举中，第i张票是在时刻为times[i]时投给候选人 persons[i]的。
     * <p>
     * 对于发生在时刻 t 的每个查询，需要找出在t 时刻在选举中领先的候选人的编号。
     * <p>
     * 在t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
     * <p>
     * 实现 TopVotedCandidate 类：
     * <p>
     * TopVotedCandidate(int[] persons, int[] times) 使用persons 和 times 数组初始化对象。
     * int q(int t) 根据前面描述的规则，返回在时刻 t 在选举中领先的候选人的编号。
     * <p>
     * 1 <= persons.length <= 5000
     * times.length == persons.length
     * 0 <= persons[i] < persons.length
     * 0 <= times[i] <= 109
     * times 是一个严格递增的有序数组
     * times[0] <= t <= 109
     * 每个测试用例最多调用 104 次 q
     */
    private static final Logger logger = LoggerFactory.getLogger(TopVotedCandidate.class);

    public TopVotedCandidate(int[] persons, int[] times) {

    }

    public int q(int t) {

        return 0;
    }

    public static void main(String[] args) {

    }
}
