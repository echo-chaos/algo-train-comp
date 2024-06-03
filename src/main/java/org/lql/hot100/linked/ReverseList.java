package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 15:26
 * @description: 206. 反转链表 <a href="https://leetcode.cn/problems/reverse-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class ReverseList {

    /**
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     * <p>
     * 输入：head = [1,2]
     * 输出：[2,1]
     * <p>
     * 输入：head = []
     * 输出：[]
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = null;
        while (head != null) {
            // 记录下一个节点
            ListNode next = head.next;
            // 翻转：头节点指向上一个节点
            head.next = last;
            // 更新：上一个节点为当前头节点
            last = head;
            // 移动：头节点移动到下一个节点
            head = next;
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
