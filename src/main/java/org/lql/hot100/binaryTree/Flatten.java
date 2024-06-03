package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 13:51
 * @description: 114. 二叉树展开为链表 <a href="https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class Flatten {

    /**
     * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
     * <p>
     * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
     * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [1,2,5,3,4,null,6]
     * 输出：[1,null,2,null,3,null,4,null,5,null,6]
     * <p>
     * 示例 2：
     * <p>
     * 输入：root = []
     * 输出：[]
     * <p>
     * 示例 3：
     * <p>
     * 输入：root = [0]
     * 输出：[0]
     * <p>
     * 提示：
     * <p>
     * 树中结点数在范围 [0, 2000] 内
     * -100 <= Node.val <= 100
     */
    public void flatten(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            // 存在左子树
            if (current.left != null) {
                // 记录当前左子节点
                TreeNode next = current.left;
                // 前驱节点，即当前的左子节点，用于后续遍历
                TreeNode pre = next;
                // 遍历查找左子树的最右子节点
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = current.right;
                // 将当前节点的左指针置为空
                current.left = null;
                // 将当前节点的右指针指向左子树
                current.right = next;
            }
            current = current.right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        new Flatten().flatten(root);
    }
}
