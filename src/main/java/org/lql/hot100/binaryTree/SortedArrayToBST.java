package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

import java.util.Random;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 16:17
 * @description: 108. 将有序数组转换为二叉搜索树 <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class SortedArrayToBST {

    /**
     * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-10,-3,0,5,9]
     * 输出：[0,-3,9,-10,null,5]
     * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
     * <p>
     * 例 2：
     * <p>
     * 输入：nums = [1,3]
     * 输出：[3,1]
     * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 按 严格递增 顺序排列
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperLeft(nums, 0, nums.length - 1);
    }

    // 中序遍历，总是选择中间位置左边的数字作为根节点
    public TreeNode helperLeft(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperLeft(nums, left, mid - 1);
        root.right = helperLeft(nums, mid + 1, right);
        return root;
    }

    // 中序遍历，总是选择中间位置右边的数字作为根节点
    public TreeNode helperRight(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right + 1) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperRight(nums, left, mid - 1);
        root.right = helperRight(nums, mid + 1, right);
        return root;
    }


    // 中序遍历，选择任意一个中间位置数字作为根节点
    public TreeNode helperRandom(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 选择任意一个中间位置数字作为根节点
        int mid = (left + right + new Random().nextInt(2)) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helperRandom(nums, left, mid - 1);
        root.right = helperRandom(nums, mid + 1, right);
        return root;
    }

}
