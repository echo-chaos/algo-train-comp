package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 16:05
 * @description: 142. 环形链表 II <a href="https://leetcode.cn/problems/linked-list-cycle-ii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class DetectCycle {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     * <p>
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     * 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
     * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     * <p>
     * 不允许修改 链表。
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        // 快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
            // 快慢指针相遇，说明有环
            if (slow == fast) {
                // 慢指针回到头节点，快指针回到头节点，慢指针和快指针每次走一步，相遇的节点就是环的入口节点
                slow = head;
                while (fast != head) {
                    fast = fast.next;
                    head = head.next;
                }
                return slow;
            }
        }
        return null;
    }

    /**
     *
     */
}
