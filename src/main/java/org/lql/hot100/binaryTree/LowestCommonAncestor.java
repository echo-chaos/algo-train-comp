package org.lql.hot100.binaryTree;

import org.lql.common.Pair;
import org.lql.common.TreeNode;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 16:18
 * @description: 236. 二叉树的最近公共祖先 <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LowestCommonAncestor {

    TreeNode p;
    TreeNode q;
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;
        dfs(root);
        return ans;
    }

    public Pair<Boolean, Boolean> dfs(TreeNode root) {
        // 当根节点为空时，既不是p的祖先也不是q的祖先
        if (root == null) {
            return new Pair<>(false, false);
        }
        // 递归搜索左子树
        Pair<Boolean, Boolean> left = dfs(root.left);
        // 递归搜索右子树
        Pair<Boolean, Boolean> right = dfs(root.right);
        // 当前节点是否是p或q的祖先或本身
        boolean key = left.getKey() || right.getKey() || root.val == p.val;
        // 当前节点是否是p或q的祖先或本身
        boolean value = left.getValue() || right.getValue() || root.val == q.val;
        // 当找到同时是p和q的祖先或本身的节点时，记录为最近公共祖先
        if (key && value && ans == null) {
            ans = root;
        }
        // 返回当前节点是否与p或q有关联
        return new Pair<>(key, value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(new LowestCommonAncestor().lowestCommonAncestor(root, root.left, root.right));
    }
}
