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
     * @param l1 前序起点
     * @param r1 前序终点
     * @param l2 中序起点
     * @param r2 中序终点
     * @return 二叉树
     */
    public TreeNode build(int l1, int r1, int l2, int r2) {
        // 边界判断：如果左边界超过右边界，说明没有元素可操作
        if (l1 > r1) {
            return null;
        }
        // 前序遍历的第一个点是根节点 -> preOrder的左边界就是根节点的值
        TreeNode root = new TreeNode(preorder[l1]);
        // 寻找中序遍历中的根节点所在位置
        int mid = l2;
        while (inorder[mid] != root.val) {
            mid++;
        }
        // l2 ~ mid-1 左子数的中序
        // mid+1 ～ r2 右子数的中序
        // 构造左子数：
        //  前序：l1 + 1 ~ l1 + (mid - 1 - l2 + 1)
        //  中序：l2 ~ mid -1
        // 构造右子数
        //  前序： l1 + 1 + （mid - l2）~ r1
        root.left = build(l1 + 1, l1 + (mid - l2), l2, mid - 1);
        root.right = build(l1 + (mid - l2) + 1, r1, mid + 1, r2);
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
