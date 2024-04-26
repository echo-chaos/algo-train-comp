package org.lql.practice.week04;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/13 20:56
 * @description: 450. 删除二叉搜索树中的节点 <a href="https://leetcode-cn.com/problems/delete-node-in-a-bst/">...</a>
 */
public class DeleteNode {

    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     * <p>
     * 一般来说，删除节点可分为两个步骤：
     * <p>
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * <p>
     * 节点数的范围[0, 104].
     * -105<= Node.val <= 105
     * 节点值唯一
     * root是合法的二叉搜索树
     * -105<= key <= 105
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            TreeNode next = root.right;
            while (next.left != null) {
                next = next.left;
            }
            root.right = deleteNode(root.right, next.val);
            root.val = next.val;
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2),
                        new TreeNode(4)),
                new TreeNode(6,
                        null,
                        new TreeNode(7)));
        TreeNode treeNode = deleteNode.deleteNode(root, 3);
        System.out.println();
    }
}
