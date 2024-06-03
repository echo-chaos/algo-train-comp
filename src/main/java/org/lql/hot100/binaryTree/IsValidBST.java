package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 16:26
 * @description: 98. 验证二叉搜索树 <a href="https://leetcode.cn/problems/validate-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MIN_VALUE, Long.MAX_VALUE);
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
        return check(root.left, leftBound, (long)root.val - 1) && check(root.right, (long)root.val + 1, rightBound);
    }
}
