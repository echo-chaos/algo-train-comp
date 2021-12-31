package org.lql.leetcode;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2021/12/28 10:28
 * @description: 206 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class ReverseList {

    /**
     * // head: 1->2->3->4->5->null
     * //
     * // curr: 2->3->4->5->null
     * // prev: 1->null
     * // next: 2->3->4->5->null
     * //
     * // curr: 3->4->5->null
     * // prev: 2->1->null
     * // next: 3->4->5->null
     * // ...
     * // curr: null
     * // prev: 5->4->3->2->1->null
     * // next: null
     */

    /**
     * 反转链表
     *
     * @param head head
     * @return res
     */
    public static ListNode reverseList(ListNode head) {
        //边界判断
        if (head == null) {
            return null;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while (curr != null) {
            //后置结点
            next = curr.next;
            //前驱结点变后驱
            curr.next = prev;
            //当前结点变前驱
            prev = curr;
            //后置结点变当前
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode reverseList = reverseList(head);
        while (reverseList != null) {
            System.out.print(reverseList.val + " -> ");
            reverseList = reverseList.next;
        }
        System.out.print("null");
    }
}
