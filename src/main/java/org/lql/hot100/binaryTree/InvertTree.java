package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 14:27
 * @description: 226. 翻转二叉树 <a href="https://leetcode.cn/problems/invert-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class InvertTree {

    /**
     * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [4,2,7,1,3,6,9]
     * 输出：[4,7,2,9,6,3,1]
     * <p>
     * 示例 2：
     * <p>
     * 输入：root = [2,1,3]
     * 输出：[2,3,1]
     * <p>
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 树中节点数目范围在 [0, 100] 内
     * -100 <= Node.val <= 100
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 递归翻转操作
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 递归翻转左子树和右子树
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

}
