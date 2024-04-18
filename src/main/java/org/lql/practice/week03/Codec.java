package org.lql.practice.week03;

import org.lql.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/2/11 22:20
 * @description: 297. 二叉树的序列化与反序列化 <a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">...</a>
 */
public class Codec {

    /**
     * 序列化是将一个数据结构或者对象转换为连续的比 特位的操作，
     * 进而可以将转换后的数据存储在一个文件或者内存中，
     * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
     * <p>
     * 请设计一个算法来实现二叉树的序列化与反序列化。
     * 这里不限定你的序列 / 反序列化算法执行逻辑，
     * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
     * <p>
     * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，
     * 详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
     * <p>
     * 树中结点数在范围 [0, 104] 内
     * -1000 <= Node.val <= 1000
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> seq = new ArrayList<>();
        dfs(seq, root);
        return String.join(",", seq);
    }

    /**
     * 前序遍历序列化二叉树
     *
     * @param seq  存储数节点信息
     * @param root 根节点
     */
    public void dfs(List<String> seq, TreeNode root) {
        if (root == null) {
            seq.add("null");
            return;
        }
        seq.add(String.valueOf(root.val));
        dfs(seq, root.left);
        dfs(seq, root.right);
    }

    String[] seq;
    int current;

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        seq = data.split(",");
        current = 0;
        return restore();
    }

    public TreeNode restore() {
        if ("null".equals(seq[current])) {
            current++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq[current]));
        current++;
        root.left = restore();
        root.right = restore();
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        String serialize = codec.serialize(root);
        System.out.println(serialize);
        TreeNode node = codec.deserialize(serialize);
        System.out.println(codec.serialize(codec.deserialize("1,2,null,null,3,4,null,null,5,null,null")));
    }

}
