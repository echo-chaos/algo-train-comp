package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 16:28
 * @description: 124. 二叉树中的最大路径和 <a href="https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class MaxPathSum {

    /**
     * 二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     */
    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        // 调用递归函数计算最大路径和
        maxGain(root);
        return maxSum;
    }

    // 计算从当前节点出发的最大贡献值
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 如果子树路径和为负，则不选取该子树（用0表示不选取）
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值加上左右子节点的最大贡献值
        int currentMaxPath = node.val + leftGain + rightGain;

        // 更新全局最大路径和
        maxSum = Math.max(maxSum, currentMaxPath);

        // 返回节点的最大贡献值（只能选择一边）
        return node.val + Math.max(leftGain, rightGain);
    }

}
