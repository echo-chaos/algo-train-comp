package org.lql.practice.week03;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/11 22:05
 * @description: 104. 二叉树的最大深度 <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">...</a>
 */
public class MaxDepth {

    /**
     * 给定一个二叉树，找出其最大深度。
     * <p>
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * <p>
     * 说明: 叶子节点是指没有子节点的节点。
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    private int depth;
    private int ans;

    public int maxDepthA(TreeNode root) {
        depth = 1;
        ans = 0;
        calc(root);
        return ans;
    }

    public void calc(TreeNode root) {
        if (root == null) {
            return;
        }
        // 更新结果
        ans = Math.max(ans, depth);
        // 递归开始层数加一
        depth++;
        calc(root.left);
        calc(root.right);
        // 一轮递归结束，回到上层，层数减1
        depth--;
    }

    public static void main(String[] args) {
        MaxDepth maxDepth = new MaxDepth();
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth.maxDepth(root));
        System.out.println(maxDepth.maxDepthA(root));
    }
}
