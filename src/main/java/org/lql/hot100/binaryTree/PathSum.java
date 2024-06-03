package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

import java.util.HashMap;

/**
 * @author: liangqinglong
 * @date: 2024-05-29 15:28
 * @description: 437. 路径总和 III <a href="https://leetcode.cn/problems/path-sum-iii/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class PathSum {

    /**
     * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
     * <p>
     * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
     */
    private HashMap<Long, Integer> prefixSum;
    private int targetSum;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        // 用于记录前缀和出现的次数
        prefixSum = new HashMap<>();
        // 初始化前缀和为0时的计数为1
        prefixSum.put(0L, 1);
        // 调用dfs函数，计算路径数量
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, long currentSum) {
        if (node == null) {
            return 0;
        }

        // 更新当前路径和
        currentSum += node.val;
        // 计算路径和为targetSum的路径数量
        int pathCount = prefixSum.getOrDefault(currentSum - targetSum, 0);

        // 更新哈希表中当前路径和的计数
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) + 1);

        // 递归遍历左子树和右子树
        pathCount += dfs(node.left, currentSum);
        pathCount += dfs(node.right, currentSum);

        // 回溯时，减少当前路径和在哈希表中的计数
        prefixSum.put(currentSum, prefixSum.getOrDefault(currentSum, 0) - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        //[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
        TreeNode root = new TreeNode(1000000000);
        root.left = new TreeNode(1000000000);
        root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);
        System.out.println(new PathSum().pathSum(root, 0));
    }
}
