package org.lql.week03;

import org.lql.common.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/1/10 22:18
 * @description: 23. 合并K个升序链表 https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeKLists {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * 示例：
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * <p>
     * 输入：lists = []
     * 输出：[]
     * <p>
     * 输入：lists = [[]]
     * 输出：[]
     * <p>
     * 提示：
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */

    private static final Logger logger = LoggerFactory.getLogger(MergeKLists.class);


    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }
}
