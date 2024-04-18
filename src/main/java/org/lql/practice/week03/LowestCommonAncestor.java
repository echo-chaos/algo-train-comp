package org.lql.practice.week03;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/13 20:33
 * @description: 236. 二叉树的最近公共祖先 <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/">...</a>
 */
public class LowestCommonAncestor {

    /**
     * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
     * <p>
     * 百度百科中最近公共祖先的定义为：
     * “对于有根树 T 的两个节点 p、q，
     * 最近公共祖先表示为一个节点 x，
     * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
     * <p>
     * 树中节点数目在范围 [2, 105] 内。
     * -109 <= Node.val <= 109
     * 所有 Node.val 互不相同 。
     * p != q
     * p 和 q 均存在于给定的二叉树中。
     */

    TreeNode p;
    TreeNode q;
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return ans;
    }

    public Pair<Boolean, Boolean> dfs(TreeNode root) {
        // 边界判断：为空，就不再是公共祖先
        if (root == null) {
            return new Pair<>(false, false);
        }
        Pair<Boolean, Boolean> left = dfs(root.left);
        Pair<Boolean, Boolean> right = dfs(root.right);
        boolean key = left.getKey() || right.getKey() || root.val == p.val;
        boolean value = left.getValue() || right.getValue() || root.val == q.val;
        if (key && value && ans == null) {
            ans = root;
        }
        return new Pair<>(key, value);
    }

    public static void main(String[] args) {
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode root = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4))),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)));
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, p, q).val);
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
