package org.lql.leetcode;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2021/12/29 21:09
 * @description: 141. 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 */
public class HasCycle {

    public static boolean hasCycle(ListNode head) {
        //边界判断
        if (head == null || head.next == null){
            return false;
        }
        //快慢指针
        ListNode slow = head;
        ListNode fast = head.next;
        //循环比较，类似跑步时被套圈
        while (slow != null && fast.next != null){
            //满足则为循环
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode node = new ListNode(9,null);
        head.next = node;
        node.next = head;
        boolean b = hasCycle(head);
        System.out.println(b);
    }
}
