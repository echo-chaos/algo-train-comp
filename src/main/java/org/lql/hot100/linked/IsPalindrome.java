package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 15:44
 * @description: 234. 回文链表 <a href="https://leetcode.cn/problems/palindrome-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class IsPalindrome {

    /**
     * 输入：head = [1,2,2,1]
     * 输出：true
     * <p>
     * 输入：head = [1,2]
     * 输出：false
     * <p>
     * 链表中节点数目在范围[1, 105] 内
     * 0 <= Node.val <= 9
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针，快指针遍历结束，慢指针恰好到中点
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 翻转后半部分链表
        ListNode last = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = last;
            last = slow;
            slow = next;
        }
        // 比较前半部分链表和后半部分链表
        ListNode p = head;
        while (last != null) {
            if (p.val != last.val) {
                return false;
            }
            p = p.next;
            last = last.next;
        }
        return true;
    }
}
