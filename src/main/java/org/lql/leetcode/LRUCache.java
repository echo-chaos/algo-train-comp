package org.lql.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/1/5 10:04
 * @description: 146. LRU 缓存 https://leetcode-cn.com/problems/lru-cache/
 */
public class LRUCache {

    /**
     * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
     * 实现 LRUCache 类：
     * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
     * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
     * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
     * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
     *
     */

    /**
     * 输入
     * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
     * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
     * 输出
     * [null, null, null, 1, null, -1, null, -1, 3, 4]
     *
     * 解释
     * LRUCache lRUCache = new LRUCache(2);
     * lRUCache.put(1, 1); // 缓存是 {1=1}
     * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
     * lRUCache.get(1);    // 返回 1
     * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
     * lRUCache.get(2);    // 返回 -1 (未找到)
     * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
     * lRUCache.get(1);    // 返回 -1 (未找到)
     * lRUCache.get(3);    // 返回 3
     * lRUCache.get(4);    // 返回 4
     *
     */

    /**
     * 提示：
     *
     * 1 <= capacity <= 3000
     * 0 <= key <= 10000
     * 0 <= value <= 105
     * 最多调用 2 * 105 次 get 和 put
     *
     */

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */

    class LRUNode {
        public int key;
        public int value;
        public LRUNode prev;
        public LRUNode next;

        public LRUNode() {
        }

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public LRUNode(int key, int value, LRUNode prev, LRUNode next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private int capacity;
    private Map<Integer, LRUNode> map = new HashMap<>(capacity);
    private LRUNode head = new LRUNode(0, 0);
    private LRUNode tail = new LRUNode(0, 0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            LRUNode lruNode = map.get(key);
            moveToFront(lruNode);
            return lruNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            // 移除最后一个节点
            if (map.size() == capacity) {
                removeLastNode();
            }
            // 放置新节点
            LRUNode temp = head.next;
            LRUNode node = new LRUNode(key, value);
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            map.put(key, node);
        } else {
            LRUNode lruNode = map.get(key);
            lruNode.value = value;
            moveToFront(lruNode);
        }
    }

    /**
     * 移除最后一个节点
     */
    private void removeLastNode() {
        LRUNode last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;
        map.remove(last.key);
    }

    /**
     * 移动到头部
     */
    private void moveToFront(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        LRUNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 1);
        lruCache.put(2, 2);
        int i = lruCache.get(2);
        System.out.println(i);
        lruCache.put(1, 1);
        lruCache.put(4, 1);
        i = lruCache.get(2);
        System.out.println(i);
        i = lruCache.get(0);
        System.out.println(i);
    }
}
