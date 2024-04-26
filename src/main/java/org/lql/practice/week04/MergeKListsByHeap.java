package org.lql.practice.week04;

import org.lql.common.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/13 20:52
 * @description: 23. 合并K个升序链表 <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">...</a>
 */
public class MergeKListsByHeap {


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
        BinaryHeap q = new BinaryHeap();
        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            q.insert(new Node(listNode.val, listNode));
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!q.empty()) {
            Node node = q.getMin();
            q.deleteMin();
            tail.next = node.listNode;
            tail = tail.next;
            ListNode next = node.listNode.next;
            if (next != null) {
                q.insert(new Node(next.val, next));
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

    static class BinaryHeap {
        private List<Node> heap;

        BinaryHeap() {
            heap = new ArrayList<>();
            heap.add(new Node(0, null));
        }

        boolean empty() {
            return heap.size() == 1;
        }

        Node getMin() {
            return heap.get(1);
        }

        void insert(Node node) {
            heap.add(node);
            heapFyUp(heap.size() - 1);
        }

        void deleteMin() {
            heap.set(1, heap.get(heap.size() - 1));
            heap.remove(heap.size() - 1);
            heapFyDown(1);
        }

        private void heapFyUp(int p) {
            while (p > 1) {
                if (heap.get(p).key < heap.get(p / 2).key) {
                    Collections.swap(heap, p, p / 2);
                    p /= 2;
                } else {
                    break;
                }
            }
        }

        private void heapFyDown(int p) {
            int child = p * 2;
            while (child < heap.size()) {
                int other = p * 2 + 1;
                if (other < heap.size() && heap.get(other).key < heap.get(child).key) {
                    child = other;
                }
                if (heap.get(child).key < heap.get(p).key) {
                    Collections.swap(heap, child, p);
                    p = child;
                    child = p * 2;
                } else {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5, null)));
        ListNode node2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode node3 = new ListNode(2, new ListNode(6, new ListNode(8, null)));
        ListNode[] lists = {node1, node2, node3};
        MergeKListsByHeap mergeKLists = new MergeKListsByHeap();
        ListNode listNode = mergeKLists.mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.print("null");
    }

}
