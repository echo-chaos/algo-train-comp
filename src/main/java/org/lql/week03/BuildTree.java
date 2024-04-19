package org.lql.week03;

import org.lql.common.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lql
 * @date: 2022/1/10 22:24
 * @description: 106. 从中序与后序遍历序列构造二叉树 <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/">...</a>
 */
public class BuildTree {

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * <p>
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private int[] inorder;
    private int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // 前序遍历 ：根节点 -> 左子树 -> 右子树
        // 中序遍历 ：左子树 -> 根节点 -> 右子树
        // 后序遍历 ：左子树 -> 右子树 -> 根节点
        // 后续遍历的末位置为根节点
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        int inorderIndex = inorder.length - 1;
        for (int i = postorder.length - 2; i >= 0; i--) {
            int postorderVal = postorder[i];
            TreeNode node = queue.peek();
            assert node != null;
            if (node.val != inorder[inorderIndex]) {
                node.right = new TreeNode(postorderVal);
                queue.push(node.right);
            } else {
                while (!queue.isEmpty() && queue.peek().val == inorder[inorderIndex]) {
                    node = queue.pop();
                    inorderIndex--;
                }
                node.left = new TreeNode(postorderVal);
                queue.push(node.left);
            }
        }
        return root;
    }

    public TreeNode buildTreeNew(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        return build(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode build(int inStart, int inEnd, int postStart, int postEnd) {
        // 边界判断
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // 后续遍历的末位置为根节点
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inStart;
        while (inorder[rootIndex] != root.val) {
            rootIndex++;
        }
        // 左子树大小
        int leftLength = rootIndex - inStart;
        root.left = build(inStart, rootIndex - 1, postStart, postStart + leftLength - 1);
        root.right = build(rootIndex + 1, inEnd, postStart + leftLength, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode treeNode = buildTree.buildTree(inorder, postorder);
        TreeNode treeNode1 = buildTree.buildTreeNew(inorder, postorder);
    }
}
