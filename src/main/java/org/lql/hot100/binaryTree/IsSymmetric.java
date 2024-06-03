package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 14:32
 * @description: 101. 对称二叉树 <a href="https://leetcode.cn/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class IsSymmetric {

    /**
     * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [1,2,2,3,4,4,3]
     * 输出：true
     * <p>
     * 示例 2：
     * <p>
     * 输入：root = [1,2,2,null,3,null,3]
     * 输出：false
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [1, 1000] 内
     * -100 <= Node.val <= 100
     */
    public boolean isSymmetric(TreeNode root) {
        // 增加空树判断，空树也认为是对称的，符合题目要求
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 判断两棵树是否为镜像对称
     *
     * @param node1 第一颗树的节点
     * @param node2 第二颗树的节点
     * @return 如果两棵树是镜像对称的，则返回true，否则返回false
     */
    private boolean isMirror(TreeNode node1, TreeNode node2) {
        // 如果两个节点都为空，说明它们是镜像对称的
        if (node1 == null && node2 == null) {
            return true;
        }
        // 如果有一个节点为空，或者节点的值不相等，说明它们不是镜像对称的
        if (node1 == null || node2 == null || node1.val != node2.val) {
            return false;
        }
        // 递归判断左右子树是否镜像对称
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }
}
