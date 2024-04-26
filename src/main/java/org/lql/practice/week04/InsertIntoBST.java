package org.lql.practice.week04;

import org.lql.common.PrintTreePreOrder;
import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/13 20:54
 * @description: 701. 二叉搜索树中的插入操作 <a href="https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/">...</a>
 */
public class InsertIntoBST {

    /**
     * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，
     * 将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
     * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
     * <p>
     * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
     * <p>
     * 树中的节点数将在[0,104]的范围内。
     * -108<= Node.val <= 108
     * 所有值Node.val是独一无二的。
     * -108<= val <= 108
     * 保证val在原始BST中不存在。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        InsertIntoBST insertIntoBST = new InsertIntoBST();
        PrintTreePreOrder printTreePreOrder = new PrintTreePreOrder();
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1), new TreeNode(3)),
                new TreeNode(7));
        System.out.println(printTreePreOrder.preorderTraversal(root));
        insertIntoBST.insertIntoBST(root, 5);
        System.out.println(printTreePreOrder.preorderTraversal(root));
    }
}
