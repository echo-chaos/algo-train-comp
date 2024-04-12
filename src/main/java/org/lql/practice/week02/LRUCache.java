package org.lql.practice.week02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:36
 * @description: 146. LRU 缓存 <a href="https://leetcode-cn.com/problems/lru-cache/">...</a>
 */
public class LRUCache {

    private static final Logger logger = LoggerFactory.getLogger(LRUCache.class);
    Map<Integer, Node> cache = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        // 从缓存中获取节点
        Node node = cache.get(key);
        // 如果节点为空
        if (node == null) {
            return -1;
        }
        // 移除原节点位置
        removeNode(node);
        // 重新插入头部
        insertNode(head, node);
        // 返回数据
        return node.value;
    }

    public void put(int key, int value) {
        // 元素不存在
        if (!cache.containsKey(key)) {
            // 新建元素节点
            Node node = new Node(key, value);
            // 放入缓存中
            cache.put(key, node);
            // 插入头部
            insertNode(head, node);
            // 判断容量
            if (cache.size() > capacity) {
                // 删除缓存中的数据
                cache.remove(tail.prev.key);
                // 删除尾节点
                removeNode(tail.prev);
            }
        } else {
            // 已存在的元素
            Node node = cache.get(key);
            node.value = value;
            // 删除原节点
            removeNode(node);
            // 重新插入头部
            insertNode(head, node);
        }
    }

    /**
     * 删除节点
     * @param node 节点
     */
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    /**
     * 插入节点
     * @param head 头节点
     * @param node 节点
     */
    public void insertNode(Node head, Node node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        public Node() {
        }
        public Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    public void printLRUCache() {
        cache.forEach((k, v) -> System.out.println("Key: " + k + ", Value: " + v.value));
    }


    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        // 缓存是 {1=1}
        lruCache.put(1, 1);
        lruCache.printLRUCache();
        // 缓存是 {1=1, 2=2}
        lruCache.put(2, 2);
        lruCache.printLRUCache();
        // 返回 1
        int i = lruCache.get(1);
        lruCache.printLRUCache();
        logger.info("lruCache.get(1) -> {} {}", 1, i);
        // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lruCache.put(3, 3);
        // 返回 -1 (未找到)
        int i1 = lruCache.get(2);
        lruCache.printLRUCache();
        logger.info("lruCache.get(2) -> {} {}", -1, i1);
        // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        lruCache.put(4, 4);
        lruCache.printLRUCache();
        // 返回 -1 (未找到)
        int i2 = lruCache.get(1);
        lruCache.printLRUCache();
        logger.info("lruCache.get(1) -> {} {}", -1, i2);
        // 返回 3
        int i3 = lruCache.get(3);
        lruCache.printLRUCache();
        logger.info("lruCache.get(3) -> {} {}", 3, i3);
        // 返回 4
        int i4 = lruCache.get(4);
        lruCache.printLRUCache();
        logger.info("lruCache.get(4) -> {} {}", 4, i4);
    }
}
