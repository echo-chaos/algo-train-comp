package org.lql.hot100.binaryTree;

import org.lql.common.Pair;
import org.lql.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 15:12
 * @description: 102. 二叉树的层序遍历 <a href="https://leetcode.cn/problems/binary-tree-level-order-traversal/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class LevelOrder {

    /**
     * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
     * <p>
     * 示例 1：
     * <p>
     * 输入：root = [3,9,20,null,null,15,7]
     * 输出：[[3],[9,20],[15,7]]
     * <p>
     * 示例 2：
     * <p>
     * 输入：root = [1]
     * 输出：[[1]]
     * <p>
     * 示例 3：
     * <p>
     * 输入：root = []
     * 输出：[]
     * <p>
     * 提示：
     * <p>
     * 树中节点数目在范围 [0, 2000] 内
     * -1000 <= Node.val <= 1000
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Pair<Integer, TreeNode>> queue = new LinkedList<>();
        queue.offer(new Pair<>(0, root));
        int trackLevel = 0;
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> pair = queue.poll();
            int level = pair.getKey();
            TreeNode node = pair.getValue();
            if (level >= trackLevel) {
                ans.add(new ArrayList<>());
                trackLevel++;
            }
            ans.get(level).add(node.val);
            if (node.left != null) {
                queue.offer(new Pair<>(level + 1, node.left));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(level + 1, node.right));
            }
        }
        return ans;
    }

    public static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public List<List<Integer>> levelOrderOf(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        LevelOrder levelOrder = new LevelOrder();
        List<List<Integer>> lists = levelOrder.levelOrder(root);
        System.out.println(lists);
    }

}
