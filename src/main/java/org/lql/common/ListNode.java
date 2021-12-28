package org.lql.common;

/**
 * @author: lql
 * @date: 2021/12/28 10:31
 * @description: 单链表
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
