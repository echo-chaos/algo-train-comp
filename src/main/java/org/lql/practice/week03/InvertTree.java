package org.lql.practice.week03;

import org.lql.common.PrintTreePreOrder;
import org.lql.common.TreeNode;

import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/11 22:03
 * @description: 226. 翻转二叉树 <a href="https://leetcode-cn.com/problems/invert-binary-tree/description/">...</a>
 */
public class InvertTree {

    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * <p>
     * 树中节点数目范围在 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        InvertTree invertTree = new InvertTree();
        PrintTreePreOrder print = new PrintTreePreOrder();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1), new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6), new TreeNode(9)));
        List<Integer> list = print.preorderTraversal(root);
        System.out.println(list);
        TreeNode treeNode = invertTree.invertTree(root);
        List<Integer> integers = print.preorderTraversal(treeNode);
        System.out.println(integers);
    }
}
