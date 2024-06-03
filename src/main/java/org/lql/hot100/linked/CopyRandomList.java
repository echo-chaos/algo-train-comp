package org.lql.hot100.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 22:09
 * @description: 138. 随机链表的复制 <a href="https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class CopyRandomList {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> cachedNode = new HashMap<Node, Node>();

    /**
     * 复制一个带有随机指针的链表。链表中的每个节点除了有一个指向下一个节点的指针（next）外，还有一个指向链表中任一个节点或null的随机指针（random）。
     *
     * @param head 给定链表的头节点
     * @return 复制链表的头节点
     */
    public Node copyRandomList(Node head) {
        // 边界条件检查
        if (head == null) {
            return null;
        }

        // 遍历链表，为每个节点创建一个副本节点，并将副本节点插入到原节点之后
        Node current = head;
        while (current != null) {
            Node newNode = new Node(current.val);
            newNode.next = current.next;
            current.next = newNode;
            current = newNode.next;
        }

        // 遍历链表，设置副本节点的随机指针
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // 分离原链表和复制链表，并设置新链表的头节点
        Node oldList = head;
        Node newList = head.next;
        Node newHead = head.next;
        while (oldList != null) {
            oldList.next = oldList.next.next;
            if (newList.next != null) {
                newList.next = newList.next.next;
            }
            oldList = oldList.next;
            newList = newList.next;
        }
        return newHead;
    }
}
