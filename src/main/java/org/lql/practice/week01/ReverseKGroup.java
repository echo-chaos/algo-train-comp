package org.lql.practice.week01;

import org.lql.common.ListNode;

/**
 * @author: lql
 * @date: 2022/2/2 23:47
 * @description: 25. K 个一组翻转链表 <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">...</a>
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0, head);
        ListNode last = protect;
        // 分组遍历
        while (head != null) {
            // 1. 分组-往后走k-1步，找到一组
            ListNode end = getEnd(head, k);
            if (end == null) {
                break;
            }
            ListNode nextGroupHead = end.next;
            // 2. 一组内部-调用反转
            reverseList(head, nextGroupHead);
            // 3. 更新每一组与前后两组之间的边
            last.next = end;
            head.next = nextGroupHead;
            last = head;
            head = nextGroupHead;
        }
        return protect.next;
    }

    /**
     * 获取k-1步的结点 ， null表示不足k个
     *
     * @param head head
     * @param k    个数
     * @return k-1个后的结点
     */
    private ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 反转链表，到结点停止
     *
     * @param head 开始结点
     * @param stop 停止结点
     * @return 反转后的一组链表
     */
    private void reverseList(ListNode head, ListNode stop) {
        ListNode last = head;
        head = head.next;
        while (head != stop) {
            // 记录下一个结点
            ListNode nextHead = head.next;
            // head指向上一个结点
            head.next = last;
            // 更新上一个结点
            last = head;
            // 头结点指向下一个结点
            head = nextHead;
        }
    }

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        ListNode head = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,new ListNode(6,new ListNode(7,null)))))));
        ListNode listNode = reverseKGroup.reverseKGroup(head, 3);
        while (listNode != null){
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.println("null");
    }
}
