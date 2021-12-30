package org.lql.leetcode;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2021/12/30 23:22
 * @description: 142. 环形链表 II https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class DetectCycle {

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                slow = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode node = new ListNode(9,null);
        head.next = node;
        node.next = head;
        ListNode b = detectCycle(head);
        System.out.println(b.val);
    }
}
