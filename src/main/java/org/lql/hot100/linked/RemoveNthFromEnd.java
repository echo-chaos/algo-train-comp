package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 20:28
 * @description: 19. 删除链表的倒数第 N 个结点 <a href="https://leetcode.cn/problems/remove-nth-node-from-end-of-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class RemoveNthFromEnd {

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4,5], n = 2
     * 输出：[1,2,3,5]
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = [1], n = 1
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1,2], n = 1
     * 输出：[1]
     * <p>
     * 提示：
     * <p>
     * 链表中结点的数目为 sz
     * 1 <= sz <= 30
     * 0 <= Node.val <= 100
     * 1 <= n <= sz
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode point = head;
        int length = 0;
        while (point != null) {
            length++;
            point = point.next;
        }
        point = dummy;
        for (int i = 0; i < length - n; i++) {
            point = point.next;
        }
        point.next = point.next.next;
        return dummy.next;
    }
}
