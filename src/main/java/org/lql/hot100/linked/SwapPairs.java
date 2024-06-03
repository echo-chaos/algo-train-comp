package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 20:36
 * @description: 24. 两两交换链表中的节点 <a href="https://leetcode.cn/problems/swap-nodes-in-pairs/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SwapPairs {

    /**
     * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
     * 示例 2：
     * <p>
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1]
     * 输出：[1]
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 100] 内
     * 0 <= Node.val <= 100
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            // 1. 获取两个节点
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            // 2. 交换节点
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = cur.next.next;
        }
        return dummy.next;
    }
}
