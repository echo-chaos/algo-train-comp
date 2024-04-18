package org.lql.practice.week03;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/11 22:13
 * @description: 111. 二叉树的最小深度 <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">...</a>
 */
public class MinDepth {

    /**
     * 给定一个二叉树，找出其最小深度。
     * <p>
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * <p>
     * 说明：叶子节点是指没有子节点的节点。
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }

    public static void main(String[] args) {
        MinDepth minDepth = new MinDepth();
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)));
        System.out.println(minDepth.minDepth(root));
    }
}
