package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 16:29
 * @description: 230. 二叉搜索树中第K小的元素 <a href="https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class KthSmallest {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
