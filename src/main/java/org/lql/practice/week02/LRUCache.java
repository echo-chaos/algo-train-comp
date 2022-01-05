package org.lql.practice.week02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/3 22:36
 * @description: 146. LRU 缓存 https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode() {
        }

        public DLinkedNode(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private Map<Integer, LRUCache.DLinkedNode> cache = new HashMap<Integer, LRUCache.DLinkedNode>();
    private int size;
    private int capacity;
    private LRUCache.DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new LRUCache.DLinkedNode();
        tail = new LRUCache.DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        LRUCache.DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LRUCache.DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            LRUCache.DLinkedNode newNode = new LRUCache.DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                LRUCache.DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        } else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(LRUCache.DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(LRUCache.DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(LRUCache.DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private LRUCache.DLinkedNode removeTail() {
        LRUCache.DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(0, 0);
        int i = lruCache.get(0);
        System.out.println(i);
    }
}
