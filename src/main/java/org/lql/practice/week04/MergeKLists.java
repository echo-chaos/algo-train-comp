package org.lql.practice.week04;

import org.lql.common.ListNode;

import java.util.PriorityQueue;

/**
 * @author: lql
 * @date: 2022/2/13 20:52
 * @description: 23. 合并K个升序链表 <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">...</a>
 */
public class MergeKLists {


    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] 按 升序 排列
     * lists[i].length 的总和不超过 10^4
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (ListNode listNode : lists) {
            if (listNode != null) {
                pq.add(new Node(listNode.val, listNode));
            }
        }

        ListNode head = new ListNode(0); // Dummy head node
        ListNode tail = head;
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            tail.next = node.listNode;
            tail = tail.next;
            ListNode next = node.listNode.next;
            if (next != null) {
                pq.add(new Node(next.val, next));
            }
        }

        return head.next;
    }

    static class Node implements Comparable<Node> {
        int key;
        ListNode listNode;

        Node(int key, ListNode listNode) {
            this.key = key;
            this.listNode = listNode;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.key, other.key);
        }
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
