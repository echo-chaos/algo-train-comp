package org.lql.practice.week03;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/11 22:04
 * @description: 98. 验证二叉搜索树 <a href="https://leetcode-cn.com/problems/validate-binary-search-tree/">...</a>
 */
public class IsValidBST {

    /**
     * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
     * <p>
     * 有效 二叉搜索树定义如下：
     * <p>
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * <p>
     * 树中节点数目范围在[1, 104] 内
     * -231 <= Node.val <= 231 - 1
     */
    public boolean isValidBST(TreeNode root) {
        // 起始边界为Integer的范围
        return check(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 验证二叉搜索树
     *
     * @param root       树节点
     * @param leftBound  左边界
     * @param rightBound 右边界
     * @return 验证结果
     */
    public boolean check(TreeNode root, long leftBound, long rightBound) {
        // 到达最后的节点，说明之前的节点都符合二叉搜索树的要求，整颗树也就符合二叉搜索树条件
        if (root == null) {
            return true;
        }
        // 当前节点的值超出父节点的边界，不符合二叉搜索树条件
        if (root.val < leftBound || root.val > rightBound) {
            return false;
        }
        // 递归遍历左右子树
        return check(root.left, leftBound, (long) root.val - 1) && check(root.right, (long) root.val + 1, rightBound);
    }

    public static void main(String[] args) {
        IsValidBST isValidBST = new IsValidBST();
        TreeNode root = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4,
                        new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST.isValidBST(root));
        TreeNode node = new TreeNode(-2147483648, new TreeNode(-2147483648), new TreeNode());
        System.out.println(isValidBST.isValidBST(node));
    }
}
