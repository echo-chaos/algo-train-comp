package org.lql.common;

/**
 * @author: lql
 * @date: 2022/1/2 18:20
 * @description: 双向链表
 */
public class DoubleEndNode {
    public int val;
    public DoubleEndNode prev;
    public DoubleEndNode next;

    public DoubleEndNode() {
    }

    public DoubleEndNode(int val) {
        this.val = val;
    }

    public DoubleEndNode(int val, DoubleEndNode prev, DoubleEndNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
