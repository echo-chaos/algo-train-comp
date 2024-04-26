package org.lql.practice.week04;

import org.lql.common.TreeNode;

/**
 * @author: lql
 * @date: 2022/2/13 20:55
 * @description: 面试题 04.06. 后继者 <a href="https://leetcode-cn.com/problems/successor-lcci/">...</a>
 */
public class InorderSuccessor {

    /**
     * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
     * <p>
     * 如果指定节点没有对应的“下一个”节点，则返回null。
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return getNext(root, p.val);
    }

    public TreeNode getNext(TreeNode root, int val) {
        TreeNode ans = null;
        TreeNode curr = root;
        while (curr != null) {
            // 找到节点
            if (curr.val == val) {
                // 判断当前节点是否有右子树
                if (curr.right != null) {
                    ans = curr.right;
                    // 从当前节点右子树开始往左子树一路向左查找后继点
                    while (ans.left != null) {
                        ans = ans.left;
                    }
                }
                break;
            }
            if (val < curr.val) {
                // 如果树中没有符合的节点，更新ans为更小的作为后继点
                if (ans == null || ans.val > curr.val) {
                    ans = curr;
                }
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        InorderSuccessor inorderSuccessor = new InorderSuccessor();
        TreeNode root = new TreeNode(2,
                new TreeNode(1),
                new TreeNode(3));
        TreeNode treeNode = inorderSuccessor.inorderSuccessor(root, new TreeNode(1));
        System.out.println(treeNode.val);
    }
}
