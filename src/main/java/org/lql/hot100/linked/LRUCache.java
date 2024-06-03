package org.lql.hot100.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liangqinglong
 * @date: 2024-05-26 10:32
 * @description: 146. LRU 缓存 <a href="https://leetcode.cn/problems/lru-cache/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LRUCache {

    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * <p>
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * <p>
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * <p>
     * void put(int key, int value)
     * <p>如果关键字 key 已经存在，则变更其数据值 value ；</p>
     * <p>如果不存在，则向缓存中插入该组 key-value 。</p>
     * <p>如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。</p>
     * <p>
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     * <p>
     * 示例：
     * <p>
     * 输入
     * <p>
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * <p>
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * <p>
     * 输出
     * <p>
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     */

    private final Map<Integer, Node> cache;
    private final int capacity;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            // 移除节点原位置
            removeNode(node);
            // 添加到头部
            insertNode(head, node);
            // 返回数据
            return node.value;
        } else {
            return -1;
        }
    }

    public synchronized void put(int key, int value) {
        // 缓存中存在
        if (cache.containsKey(key)) {
            // 获取原节点
            Node node = cache.get(key);
            // 更新节点数据
            node.value = value;
            // 删除原节点
            removeNode(node);
            // 添加到头部
            insertNode(head, node);
        } else {
            // 新建节点
            Node node = new Node(key, value);
            // 放入缓存
            cache.put(key, node);
            // 添加到头部
            insertNode(head, node);
            // 判断容量
            if (cache.size() > capacity) {
                // 获取尾部节点
                Node removeNode = tail.prev;
                // 移除缓存
                cache.remove(removeNode.key);
                // 移除尾部节点
                removeNode(tail.prev);
            }
        }
    }

    /**
     * 在指定节点后插入新节点
     *
     * @param target 目标节点
     * @param node   准备插入的节点
     */
    public void insertNode(Node target, Node node) {
        node.prev = target;
        node.next = target.next;
        target.next.prev = node;
        target.next = node;
    }

    /**
     * 移除节点
     */
    public void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static class Node {
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

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
