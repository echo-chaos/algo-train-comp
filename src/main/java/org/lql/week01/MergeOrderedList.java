package org.lql.week01;

import org.lql.common.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2021/12/28 9:07
 * @description: 21 合并两个有序链表  https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeOrderedList {

    /**
     * <p>题目：</p>
     * <li>将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。</li>
     * <P>示例1: </P>
     * <li>输入：l1 = [1,2,4], l2 = [1,3,4]</li>
     * <li>输出：[1,1,2,3,4,4]</li>
     * <p>示例2：</p>
     * <li>输入：l1 = [], l2 = []</li>
     * <li>输出：[]</li>
     */

    private static final Logger logger = LoggerFactory.getLogger(MergeOrderedList.class);

    /**
     * 合并两个有序链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //边界判断
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res = new ListNode(0, null);
        ListNode curr = res;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        //比较完成之后剩余链表自动合并到结果后边
        if (list1 != null) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4, null)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4, null)));
        ListNode listNode = mergeTwoLists(list1, list2);
        while (listNode != null) {
            System.out.print(listNode.val + " -> ");
            listNode = listNode.next;
        }
        System.out.print("null");
    }
}