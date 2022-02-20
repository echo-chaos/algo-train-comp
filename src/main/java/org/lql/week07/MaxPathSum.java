package org.lql.week07;

import org.lql.common.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: lql
 * @date: 2022/2/20 10:10 PM
 * @description: 124. 二叉树中的最大路径和 https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {

    /**
     * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。
     * 同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
     * <p>
     * 路径和 是路径中各节点值的总和。
     * <p>
     * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
     * <p>
     * 树中节点数目范围是 [1, 3 * 104]
     * -1000 <= Node.val <= 1000
     */
    private static final Logger logger = LoggerFactory.getLogger(MaxPathSum.class);

    public int maxPathSum(TreeNode root) {
        return 0;
    }
}
