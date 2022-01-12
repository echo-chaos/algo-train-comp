package org.lql.leetcode;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/1/12 22:19
 * @description: 98. 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return checkRootNode(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean checkRootNode(TreeNode root, long boundaryLeft, long boundRight) {
        if (root == null) {
            return true;
        }
        if (root.val < boundaryLeft || root.val > boundRight) {
            return false;
        }
        return checkRootNode(root.left, boundaryLeft, (long) root.val - 1) &&
                checkRootNode(root.right, (long) root.val + 1, boundRight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        IsValidBST isValidBST = new IsValidBST();
        boolean validBST = isValidBST.isValidBST(root);
        System.out.println(validBST);

    }
}
