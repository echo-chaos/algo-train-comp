package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 20:47
 * @description: 25. K 个一组翻转链表 <a href="https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class ReverseKGroup {

    /**
     * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
     * <p>
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * <p>
     * 提示：
     * 链表中的节点数目为 n
     * 1 <= k <= n <= 5000
     * 0 <= Node.val <= 1000
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        ListNode last = dummy;
        while (head != null) {
            // 找到翻转的起点
            ListNode kth = getEnd(head, k);
            // 如果kth 为空，说明剩余节点不足 k 个，不需要翻转
            if (kth == null) {
                break;
            }
            // 下一组的头节点
            ListNode nextGroupHead = kth.next;
            // 进行组间翻转
            reverse(head, nextGroupHead);
            // 更新组间关系
            // 上一次的头节点指向当前尾节点（翻转之后的头节点）
            last.next = kth;
            // 当前组的头节点指向下一组的头节点（翻转之后的尾节点）
            head.next = nextGroupHead;
            // last更新为当前组的尾节点（翻转后的尾节点）
            last = head;
            // head更新为下一组的头节点
            head = nextGroupHead;
        }
        return dummy.next;
    }

    /**
     * 找到第 k 个节点
     */
    public ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    public void reverse(ListNode head, ListNode stop) {
        ListNode last = head;
        while (head != stop) {
            ListNode next = head.next;
            head.next = last;
            last = head;
            head = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode listNode = reverseKGroup.reverseKGroup(head, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


}
