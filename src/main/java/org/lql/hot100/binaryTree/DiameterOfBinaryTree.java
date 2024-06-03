package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 14:38
 * @description: 543. 二叉树的直径 <a href="https://leetcode.cn/problems/diameter-of-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class DiameterOfBinaryTree {

    /**
     * 给你一棵二叉树的根节点，返回该树的 直径 。
     * <p>
     * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
     * <p>
     * 两节点之间路径的 长度 由它们之间边数表示。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [1,2,3,4,5]
     * 输出：3
     * 解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
     * 示例 2：
     * <p>
     * 输入：root = [1,2]
     * 输出：1
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [1, 104] 内
     * -100 <= Node.val <= 100
     */
    private int maxDiameter; // 记录全局的最大直径

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0; // 初始化最大直径为0
        dfs(root); // 深度优先遍历
        return maxDiameter; // 返回计算得到的直径
    }

    // 深度优先遍历，返回经过当前节点的最长路径长度（单边）
    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftDepth = dfs(node.left); // 左子树的最大深度
        int rightDepth = dfs(node.right); // 右子树的最大深度

        // 更新全局最大直径，可能经过当前节点或不经过当前节点
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);

        // 返回当前节点为根的最长路径（单边），用于上级调用计算
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
