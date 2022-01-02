package org.lql.leetcode;

import org.lql.common.ListNode;

import java.util.Arrays;

/**
 * @author: lql
 * @date: 2022/1/2 14:15
 * @description: 25. K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseGroup {

    public ListNode reverseGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        ListNode pre = hair;
        while (head != null) {
            ListNode tail = pre;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return hair.next;
                }
            }
            ListNode next = tail.next;
            ListNode[] reverse = reverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            pre.next = head;
            tail.next = next;
            pre = tail;
            head = tail.next;
        }
        return hair.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,null)))))));
        ReverseGroup reverseGroup = new ReverseGroup();
        ListNode listNode = reverseGroup.reverseGroup(head, 3);
        int[] origin = {1,2,3,4,5,6,7};
        System.out.println("origin: "+ Arrays.toString(origin));
        System.out.print("res:  ");
        while (listNode != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println("null");
    }
}
