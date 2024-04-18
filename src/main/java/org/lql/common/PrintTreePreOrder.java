package org.lql.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 前序遍历打印二叉树
 * @author: liangqinglong
 * @date: 2024-04-15 22:37
 **/
public class PrintTreePreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

}
