package org.lql.hot100.binaryTree;

import org.lql.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: liangqinglong
 * @date: 2024-05-26 14:00
 * @description: 94. 二叉树的中序遍历 <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/?envType=study-plan-v2&envId=top-100-liked">...</a>
 **/
public class InorderTraversal {

    /**
     * 前序遍历：先访问根节点，再访问左子树，最后访问右子树。
     * <p>
     * 中序遍历：先访问左子树，再访问根节点，最后访问右子树。
     * <p>
     * 后序遍历：先访问左子树，再访问右子树，最后访问根节点。
     */

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorderSeq = new ArrayList<>();
        if (root == null) {
            return preorderSeq;
        }
        preorderDfs(root, preorderSeq);
        return preorderSeq;
    }

    public void preorderDfs(TreeNode root, List<Integer> seq) {
        if (root == null) {
            return;
        }
        seq.add(root.val);
        preorderDfs(root.left, seq);
        preorderDfs(root.right, seq);
    }


    public List<Integer> preorderTraversalIterative(TreeNode root) {
        List<Integer> preorderIterativeSeq = new ArrayList<>();
        if (root == null) {
            return preorderIterativeSeq;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 栈顶元素出栈，并放入列表中
            TreeNode node = stack.pop();
            preorderIterativeSeq.add(node.val);
            // 将右子树放入栈中，再将左子树放入栈中，保证先访问右子树后访问左子树
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return preorderIterativeSeq;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorderSeq = new ArrayList<>();
        if (root == null) {
            return inorderSeq;
        }
        inorderDfs(root, inorderSeq);
        return inorderSeq;
    }

    public void inorderDfs(TreeNode root, List<Integer> seq) {
        if (root == null) {
            return;
        }
        inorderDfs(root.left, seq);
        seq.add(root.val);
        inorderDfs(root.right, seq);
    }

    public List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> inorderIterativeSeq = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        // 遍历二叉树直到所有节点都被访问
        while (current != null || !stack.isEmpty()) {
            // 遍历当前节点的左子树，将所有左节点压入栈中
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // 当没有左节点可访问时，弹出栈顶节点并访问
            current = stack.pop();
            inorderIterativeSeq.add(current.val);
            // 转向右子树继续遍历
            current = current.right;
        }
        return inorderIterativeSeq;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorderSeq = new ArrayList<>();
        if (root == null) {
            return postorderSeq;
        }
        postorderDfs(root, postorderSeq);
        return postorderSeq;
    }

    public void postorderDfs(TreeNode root, List<Integer> seq) {
        if (root == null) {
            return;
        }
        postorderDfs(root.left, seq);
        postorderDfs(root.right, seq);
        seq.add(root.val);
    }

    public List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> postorderIterativeSeq = new ArrayList<>();
        if (root == null) {
            return postorderIterativeSeq;
        }
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);
        // 第一个栈用于遍历节点，第二个栈用于存储遍历顺序
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node);
            // 先将左节点入栈，再将右节点入栈，保证后序遍历的顺序
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }
        // 遍历第二个栈，按后序遍历顺序添加节点值到结果列表
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            postorderIterativeSeq.add(node.val);
        }
        return postorderIterativeSeq;
    }


    public static void main(String[] args) {
        // 构建二叉树
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        InorderTraversal traversal = new InorderTraversal();

        // 前序遍历
        System.out.println("前序遍历: 1 2 4 5 3 ");
        System.out.println("前序遍历-递归: " + traversal.preorderTraversal(root));
        System.out.println("前序遍历-迭代: " + traversal.preorderTraversalIterative(root));
        // 中序遍历
        System.out.println("中序遍历: 4 2 5 1 3 ");
        System.out.println("中序遍历-递归: " + traversal.inorderTraversal(root));
        System.out.println("中序遍历-迭代: " + traversal.inorderTraversalIterative(root));
        // 后续遍历
        System.out.println("后序遍历: 4 5 2 3 1 ");
        System.out.println("后序遍历-递归: " + traversal.postorderTraversal(root));
        System.out.println("后序遍历-迭代: " + traversal.postorderTraversalIterative(root));
    }
}
