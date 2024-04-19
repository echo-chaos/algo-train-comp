package org.lql.practice.week03;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/13 20:31
 * @description: 105. 从前序与中序遍历序列构造二叉树 <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">...</a>
 */
public class BuildTree {

    /**
     * 给定两个整数数组preorder 和 inorder，
     * 其中preorder 是二叉树的先序遍历， inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * <p>
     * 1 <= preorder.length <= 3000
     * inorder.length == preorder.length
     * -3000 <= preorder[i], inorder[i] <= 3000
     * preorder和inorder均 无重复 元素
     * inorder均出现在preorder
     * preorder保证 为二叉树的前序遍历序列
     * inorder保证 为二叉树的中序遍历序列
     */

    int[] preorder;
    int[] inorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        return build(0, preorder.length - 1, 0, inorder.length - 1);
    }


    /**
     * 前序遍历：根-左-右
     * 中序遍历：左-根-右
     * 后序遍历：左-右-根
     *
     * @param preStart 前序起点
     * @param preEnd   前序终点
     * @param inStart  中序起点
     * @param inEnd    中序终点
     * @return 二叉树
     */
    public TreeNode build(int preStart, int preEnd, int inStart, int inEnd) {
        // 边界判断：如果左边界超过右边界，说明没有元素可操作
        if (preStart > preEnd) {
            return null;
        }
        // 前序遍历的第一个点是根节点 -> preOrder的左边界就是根节点的值
        TreeNode root = new TreeNode(preorder[preStart]);
        // 寻找中序遍历中的根节点所在位置
        int mid = inStart;
        while (inorder[mid] != root.val) {
            mid++;
        }
        // inStart ~ mid-1 左子数的中序
        // mid+1 ～ inEnd 右子数的中序
        // 构造左子数：
        //  前序：preStart + 1 ~ preStart + (mid - 1 - inStart + 1)
        //  中序：inStart ~ mid -1
        // 构造右子数
        //  前序： preStart + 1 + （mid - inStart）~ preEnd
        root.left = build(preStart + 1, preStart + (mid - inStart), inStart, mid - 1);
        root.right = build(preStart + (mid - inStart) + 1, preEnd, mid + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = buildTree.buildTree(preorder, inorder);
        System.out.println(root.toString());
    }
}
