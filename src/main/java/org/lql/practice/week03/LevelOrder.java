package org.lql.practice.week03;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * @author: lql
 * @date: 2022/2/11 22:19
 * @description: 429. N 叉树的层序遍历 <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">...</a>
 */
public class LevelOrder {

    /**
     * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
     * <p>
     * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
     * <p>
     * 树的高度不会超过 1000
     * 树的节点总数在 [0, 10^4] 之间
     */
    public List<List<Integer>> levelOrder(Node root) {
        // 队列：存放二元组-> 节点-深度
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        List<List<Integer>> seq = new ArrayList<>();
        if (root == null) {
            return seq;
        }
        // 将第一层放进队列
        queue.add(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            // 取出队列内元素
            Node node = queue.peek().getKey();
            Integer depth = Objects.requireNonNull(queue.poll()).getValue();
            // 如果当前深度大于元素数量,新的一层开始，需要开辟一层的空间存放
            if (depth >= seq.size()) {
                seq.add(new ArrayList<>());
            }
            // 将对应depth层的数据放入list
            seq.get(depth).add(node.val);
            // 逐层遍历
            for (Node child : node.children) {
                queue.add(new Pair<>(child, depth + 1));
            }
        }
        return seq;
    }

    public static void main(String[] args) {
        LevelOrder levelOrder = new LevelOrder();
        Node root = new Node(
                1,
                new ArrayList<>(Arrays.asList(new Node(3,
                                Arrays.asList(new Node(5, new ArrayList<>()), new Node(6, new ArrayList<>()))),
                        new Node(2, new ArrayList<>()),
                        new Node(4, new ArrayList<>())
                ))
        );
        System.out.println(levelOrder.levelOrder(root));
    }

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

}
