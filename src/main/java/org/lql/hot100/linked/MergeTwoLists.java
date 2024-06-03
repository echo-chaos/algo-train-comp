package org.lql.hot100.linked;

import org.lql.common.ListNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-25 16:30
 * @description: 21. 合并两个有序链表 <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
        if (list1 != null ) {
            curr.next = list1;
        }
        if (list2 != null) {
            curr.next = list2;
        }
        return res.next;
    }
}
