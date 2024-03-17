package org.lql.practice.week01;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2022/2/2 23:52
 * @description: 141. 环形链表 <a href="https://leetcode-cn.com/problems/linked-list-cycle/">...</a>
 */
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode node = new ListNode(9,null);
        head.next = node;
        node.next = head;
        boolean b = hasCycle.hasCycle(head);
        System.out.println(b);
    }
}
