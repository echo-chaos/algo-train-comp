package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-26 15:34
 * @description: 104. 二叉树的最大深度 <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MaxDepth {

    private int depth;
    private int ans;

    public int maxDepth(TreeNode root) {
        depth = 1;
        ans = 0;
        calcDepth(root);
        return ans;
    }

    public void calcDepth(TreeNode root) {
        // 如果根节点为空，直接返回，无需计算深度
        if (root == null) {
            return;
        }
        // 更新当前最大深度ans，保证ans始终保存最大的深度值
        ans = Math.max(ans, depth);
        // 进入左子树或右子树前，先增加深度计数
        depth++;
        // 递归计算左子树的深度
        calcDepth(root.left);
        // 递归计算右子树的深度
        calcDepth(root.right);
        // 从子树返回父节点时，减少深度计数
        depth--;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth2(root.left), maxDepth2(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new MaxDepth().maxDepth(root));
    }
}
