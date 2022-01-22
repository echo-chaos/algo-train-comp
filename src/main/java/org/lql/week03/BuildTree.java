package org.lql.week03;

import org.lql.common.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: lql
 * @date: 2022/1/10 22:24
 * @description: 106. 从中序与后序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class BuildTree {

    /**
     * 根据一棵树的中序遍历与后序遍历构造二叉树。
     *
     * 注意:
     * 你可以假设树中没有重复的元素。
     *
     * 中序遍历 inorder = [9,3,15,20,7]
     * 后序遍历 postorder = [9,15,7,20,3]
     * 返回如下的二叉树：
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     */
    private static final Logger logger = LoggerFactory.getLogger(BuildTree.class);

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

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};
        TreeNode treeNode = buildTree.buildTree(inorder, postorder);
    }
}
