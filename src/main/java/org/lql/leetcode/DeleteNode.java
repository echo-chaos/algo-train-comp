package org.lql.leetcode;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/1/23 0:30
 * @description: 450. 删除二叉搜索树中的节点 https://leetcode-cn.com/problems/delete-node-in-a-bst/
 */
public class DeleteNode {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }
        if (root.val == key){
            if (root.left == null){
                return root.right;
            }
            if (root.right == null){
                return root.left;
            }
            TreeNode next = root.right;
            while (next.left != null){
                next = next.left;
            }
            root.right = deleteNode(root.right, next.val);
            root.val = next.val;
            return root;
        }else if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }
        return root;
    }
}
