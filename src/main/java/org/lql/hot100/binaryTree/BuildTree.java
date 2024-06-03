package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 15:13
 * @description: 105. 从前序与中序遍历序列构造二叉树 <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class BuildTree {

    int[] preorder;
    int[] inorder;

    /**
     * 给定两个整数数组 preorder 和 inorder ，
     * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * <p>
     * 示例 1:
     * <p>
     * 输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
     * 输出: [3,9,20,null,null,15,7]
     * 示例 2:
     * <p>
     * 输入: preorder = [-1], inorder = [-1]
     * 输出: [-1]
     * <p>
     * * 前序遍历：根-左-右
     * <p>
     * * 中序遍历：左-根-右
     * <p>
     * * 后序遍历：左-右-根
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode build(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的初始位置为根节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 寻找中序遍历的根节点
        int rootIndex = 0;
        while (rootIndex < inEnd && inorder[rootIndex] != rootVal) {
            rootIndex++;
        }
        // 左子树长度
        int leftSize = rootIndex - inStart;
        root.left = build(preStart + 1, preStart + leftSize, inStart, rootIndex - 1);
        root.right = build(preStart + leftSize + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }
}
