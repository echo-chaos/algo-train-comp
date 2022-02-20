package org.lql.leetcode;

import org.lql.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lql
 * @date: 2022/2/20 6:53 PM
 * @description: 337. 打家劫舍 III https://leetcode-cn.com/problems/house-robber-iii/
 */
public class RobIII {

    /**
     * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
     * <p>
     * 除了root之外，每栋房子有且只有一个“父“房子与之相连。
     * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     * <p>
     * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额。
     * <p>
     * <p>
     * 树的节点数在 [1, 104] 范围内
     * 0 <= Node.val <= 104
     */

    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
