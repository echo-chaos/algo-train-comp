package org.lql.practice.week03;

import org.lql.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/11 22:17
 * @description: 94. 二叉树的中序遍历 <a href="https://leetcode-cn.com/problems/binary-tree-inorder-traversal/">...</a>
 */
public class InorderTraversal {

    /**
     * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
     * <p>
     * 树中节点数目在范围 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    public List<Integer> seq;

    public List<Integer> inorderTraversal(TreeNode root) {
        seq = new ArrayList<>();
        if (root == null) {
            return seq;
        }
        dfs(root);
        return seq;
    }

    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 左 - 根 - 右
        dfs(root.left);
        seq.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3), null));
        System.out.println(inorderTraversal.inorderTraversal(root));
    }
}
