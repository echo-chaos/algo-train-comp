package org.lql.practice.week01;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2022/2/2 23:44
 * @description: 206. 反转链表 <a href="https://leetcode-cn.com/problems/reverse-linked-list/">...</a>
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null){
            // 记录下一个结点
            ListNode nextHead = head.next;
            // head指向上一个结点
            head.next = last;
            // 更新上一个结点
            last = head;
            // 头结点指向下一个结点
            head = nextHead;
        }
        return last;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode listNode = reverseList.reverseList(head);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.print("null");
    }
}
