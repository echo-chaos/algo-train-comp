package org.lql.hot100.linked;

import org.lql.common.ListNode;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 23:07
 * @description: 23. 合并 K 个升序链表 <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MergeKLists {

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * <p>
     * 输出：[1,1,2,3,4,4,5,6]
     * <p>
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * <p>
     * 示例 2：
     * <p>
     * 输入：lists = []
     * <p>
     * 输出：[]
     * <p>
     * 示例 3：
     * <p>
     * 输入：lists = [[]]
     * <p>
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
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

    private ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode res = new ListNode(0, null);
        ListNode temp = res;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                temp.next = node1;
                node1 = node1.next;
            } else {
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if (node1 != null) {
            temp.next = node1;
        }
        if (node2 != null) {
            temp.next = node2;
        }
        return res.next;
    }

    public ListNode mergeKListsA(ListNode[] lists) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.key));

        for (ListNode listNode : lists) {
            if (listNode != null) {
                q.offer(new Node(listNode.val, listNode));
            }
        }

        ListNode head = new ListNode();
        ListNode tail = head;

        while (!q.isEmpty()) {
            Node node = q.poll();
            tail.next = node.listNode;
            tail = tail.next;
            ListNode next = node.listNode.next;
            if (next != null) {
                q.offer(new Node(next.val, next));
            }
        }

        return head.next;
    }

    static class Node {
        int key;
        ListNode listNode;

        Node(int key, ListNode listNode) {
            this.key = key;
            this.listNode = listNode;
        }
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);
        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        ListNode listNode = mergeKLists.mergeKListsA(new ListNode[]{listNode1, listNode2, listNode3});
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
