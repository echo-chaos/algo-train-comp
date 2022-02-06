package org.lql.week04;

import org.lql.common.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/1/23 14:29
 * @description: 538. 把二叉搜索树转换为累加树 https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 */
public class ConvertBST {

    /**
     * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
     * <p>
     * 提醒一下，二叉搜索树满足下列约束条件：
     * <p>
     * 节点的左子树仅包含键 小于 节点键的节点。
     * 节点的右子树仅包含键 大于 节点键的节点。
     * 左右子树也必须是二叉搜索树。
     */
    private static final Logger logger = LoggerFactory.getLogger(ConvertBST.class);

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        ConvertBST convertBST = new ConvertBST();
        TreeNode root = new TreeNode(3, new TreeNode(2, new TreeNode(1), new TreeNode()), new TreeNode(1));
        TreeNode node = convertBST.convertBST(root);
        System.out.println(node);
    }
}
