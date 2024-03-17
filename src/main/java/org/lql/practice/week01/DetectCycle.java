package org.lql.practice.week01;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2022/2/2 23:53
 * @description: 142. 环形链表 II <a href="https://leetcode-cn.com/problems/linked-list-cycle-ii/">...</a>
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
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
        DetectCycle detectCycle = new DetectCycle();
        ListNode listNode = detectCycle.detectCycle(head);
        System.out.println(listNode.val);
    }
}
