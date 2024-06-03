package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 22:50
 * @description: 148. 排序链表 <a href="https://leetcode.cn/problems/sort-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SortList {

    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [4,2,1,3]
     * 输出：[1,2,3,4]
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [-1,5,3,4,0]
     * 输出：[-1,0,3,4,5]
     * <p>
     * 示例 3：
     * <p>
     * 输入：head = []
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 5 * 104] 内
     * -105 <= Node.val <= 105
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 找到链表中点
        ListNode mid = getMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        // 将链表从中点断开
        mid.next = null;

        // 递归地对两半进行排序
        left = sortList(left);
        right = sortList(right);

        //  合并两个有序链表
        return merge(left, right);
    }

    /**
     * 获取链表的中点
     */
    public ListNode getMid(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 合并两个有序链表
     */
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if (left != null) {
            cur.next = left;
        }
        if (right != null) {
            cur.next = right;
        }
        return dummy.next;
    }
}
