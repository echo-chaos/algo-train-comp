package org.lql.practice.week03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author: lql
 * @date: 2022/2/11 22:18
 * @description: 589. N 叉树的前序遍历 <a href="https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/">...</a>
 */
public class Preorder {

    /**
     * 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
     * <p>
     * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
     * <p>
     * 节点总数在范围 [0, 104]内
     * 0 <= Node.val <= 104
     * n 叉树的高度小于或等于 1000
     */
    public List<Integer> seq;

    public List<Integer> preorder(Node root) {
        seq = new ArrayList<>();
        dfs(root);
        return seq;
    }

    public void dfs(Node root) {
        if (root == null) {
            return;
        }
        // 根 - 左 - 右
        seq.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }

    public List<Integer> res;

    public List<Integer> preorderStack(Node root) {
        res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
               stack.push(node.children.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Preorder preorder = new Preorder();
        Node root = new Node(1,
                Arrays.asList(new Node(3,
                                new ArrayList<>(
                                        Arrays.asList(
                                                new Node(5, new ArrayList<>()),
                                                new Node(6, new ArrayList<>())))),
                        new Node(2, new ArrayList<>()),
                        new Node(4, new ArrayList<>())));
        System.out.println(preorder.preorder(root));
        System.out.println(preorder.preorderStack(root));
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
}
