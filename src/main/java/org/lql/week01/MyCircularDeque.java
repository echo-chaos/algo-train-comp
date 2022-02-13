package org.lql.week01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2021/12/28 22:31
 * @description: 641. 设计循环双端队列 https://leetcode-cn.com/problems/design-circular-deque/
 */
public class MyCircularDeque {

    private static final Logger logger = LoggerFactory.getLogger(MyCircularDeque.class);

    /**
     * <p>设计实现双端队列。</p>
     * <p>你的实现需要支持以下操作：</p>
     *
     * <li>MyCircularDeque(k)：构造函数,双端队列的大小为k。</li>
     * <li>insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。</li>
     * <li>insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。</li>
     * <li>deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。</li>
     * <li>deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。</li>
     * <li>getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。</li>
     * <li>getRear()：获得双端队列的最后一个元素。如果双端队列为空，返回 -1。</li>
     * <li>isEmpty()：检查双端队列是否为空。</li>
     * <li>isFull()：检查双端队列是否满了。</li>
     *
     * <p>提示：</p>
     *
     * <li>所有值的范围为 [1, 1000]</li>
     * <li>操作次数的范围为 [1, 1000]</li>
     * <li>请不要使用内置的双端队列库。</li>
     */

    /**
     * head <-> node <-> tail
     */
    private int capacity;
    private int size;
    private ListNode head;
    private ListNode tail;

    /**
     * 双向链表
     */
    class ListNode {
        int value;
        ListNode prev;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    public MyCircularDeque(int k) {
        capacity = k;
    }

    /**
     * insertFront
     * node
     * :    head <-> node_1 <-> node_2 ... node_n <-> tail
     *
     * @param value val
     * @return res
     */
    public boolean insertFront(int value) {
        // 判断队列是否已满
        if (isFull()) {
            return false;
        }
        // 构造新节点
        ListNode node = new ListNode(value);
        // 新节点指向头结点
        node.next = head;
        if (head != null) {
            head.prev = node;
        }
        // 头结点向前移动
        head = node;
        // 初次插入，指定为尾节点
        if (tail == null) {
            tail = node;
        }
        size++;
        return true;
    }

    /**
     * insertLast
     * :                                              node
     * head <-> node_1 <-> node_2 ... node_n <-> tail
     *
     * @param value val
     * @return res
     */
    public boolean insertLast(int value) {
        // 判断队列是否已满
        if (isFull()) {
            return false;
        }
        // 构造新节点
        ListNode node = new ListNode(value);
        node.prev = tail;
        if (tail != null) {
            tail.next = node;
        }
        // 尾节点向后移动
        tail = node;
        // 初次插入
        if (head == null) {
            head = node;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        // 判断链表是否为空
        if (isEmpty()) {
            return false;
        }
        // 将要被删除的节点
        ListNode next = head.next;
        if (next != null) {
            next.prev = null;
            // 释放原有头结点
            head.next = null;
        } else {
            tail = null;
        }
        // 头结点向后移动
        head = next;
        size--;
        return true;
    }

    public boolean deleteLast() {
        // 判断链表是否为空
        if (isEmpty()) {
            return false;
        }
        ListNode prev = tail.prev;
        if (prev != null) {
            prev.next = null;
            tail.prev = null;
        } else {
            head = null;
        }
        // 尾节点向前移动
        tail = prev;
        size--;
        return true;
    }

    public int getFront() {
        return head == null ? -1 : head.value;
    }

    public int getRear() {
        return tail == null ? -1 : tail.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void printDeque(MyCircularDeque deque) {
        logger.info("----------start---------------");
        logger.info("size -> {}", deque.size);
        logger.info("capacity -> {}", deque.capacity);
        if (!deque.isEmpty()) {
            logger.info("head -> {}", deque.head.value);
            logger.info("tail -> {}", deque.tail.value);
        }
        logger.info("getFront -> {}", deque.getFront());
        logger.info("getRear -> {}", deque.getRear());
        logger.info("----------end---------------");
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        deque.printDeque(deque);
        boolean isSuccess;
        isSuccess = deque.insertLast(1);
        logger.info("insertLast -> {}", isSuccess);
        isSuccess = deque.insertLast(2);
        logger.info("insertLast -> {}", isSuccess);
        isSuccess = deque.insertFront(3);
        logger.info("insertFront -> {}", isSuccess);
        isSuccess = deque.insertFront(4);
        logger.info("insertFront -> {}", isSuccess);
        deque.printDeque(deque);
        int rear = deque.getRear();
        logger.info("getRear -> {}", rear);
        boolean full = deque.isFull();
        logger.info("isFull -> {}", full);
        isSuccess = deque.deleteLast();
        logger.info("deleteLast -> {}", isSuccess);
        isSuccess = deque.insertFront(4);
        logger.info("insertFront -> {}", isSuccess);
        int front = deque.getFront();
        logger.info("getFront -> {}", front);
    }

}
