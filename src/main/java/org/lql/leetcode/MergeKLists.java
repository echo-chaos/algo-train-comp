package org.lql.leetcode;

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
        if (lists.length == 0) {
            return null;
        }
        int length = lists.length;
        return solve(0, length - 1, lists);
    }

    private ListNode solve(int start, int end, ListNode[] lists) {
        if (start == end) {
            return lists[start];
        }
        int mid = (end - start) / 2 + start;
        ListNode left = solve(start, mid, lists);
        ListNode right = solve(mid + 1, end, lists);
        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode(0, null);
        ListNode curr = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode node3 = new ListNode(2, new ListNode(6, new ListNode(8, null)));
        ListNode[] lists = {node1, node2, node3};
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(lists);
        while (listNode != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.print("null");
    }
}
