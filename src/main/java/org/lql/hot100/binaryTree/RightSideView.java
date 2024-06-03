package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

/**
 * @author: liangqinglong
 * @date: 2024-05-28 16:41
 * @description: 199. 二叉树的右视图 <a href="https://leetcode.cn/problems/binary-tree-right-side-view/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<>();
        int max_depth = -1;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(root);
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                // 维护二叉树的最大深度
                max_depth = Math.max(max_depth, depth);

                // 由于每一层最后一个访问到的节点才是我们要的答案，因此不断更新对应深度的信息即可
                rightmostValueAtDepth.put(depth, node.val);

                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);
            }
        }

        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }


    public List<Integer> rightSideViewL(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<Group<Integer, Integer, TreeNode>> queue = new LinkedList<>();
        queue.offer(new Group<>(0, 0, root));
        List<Group<Integer, Integer, Integer>> list = new ArrayList<>();
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            Group<Integer, Integer, TreeNode> group = queue.poll();
            TreeNode node = group.getNode();
            Integer level = group.getLevel();
            Integer index = group.getIndex();
            if (maxLevel < level) {
                maxLevel = level;
            }
            list.add(new Group<>(level, index, node.val));
            if (node.left != null) {
                queue.offer(new Group<>(level + 1, index * 2, node.left));
            }
            if (node.right != null) {
                queue.offer(new Group<>(level + 1, index * 2 + 1, node.right));
            }
        }
        for (int i = 0; i <= maxLevel; i++) {
            int index = i;
            Optional<Integer> val = list.stream()
                    .filter(group -> group.level == index)
                    .max(Comparator.comparingInt(Group::getIndex))
                    .map(Group::getNode);
            val.ifPresent(res::add);
        }
        return res;
    }

    // 三元组：记录树节点的层级、索引、值
    public static class Group<L, I, T> {
        private final L level;
        private final I index;
        private final T node;

        public Group(L level, I index, T node) {
            this.level = level;
            this.index = index;
            this.node = node;
        }

        public L getLevel() {
            return level;
        }

        public I getIndex() {
            return index;
        }

        public T getNode() {
            return node;
        }
    }

    public List<Integer> rightSideViewGPT(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int rightMostVal = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                rightMostVal = node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(rightMostVal);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(4))
        );
        RightSideView rightSideView = new RightSideView();
        System.out.println(rightSideView.rightSideViewGPT(root));
    }
}
