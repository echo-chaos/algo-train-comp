package org.lql.leetcode;

import org.lql.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lql
 * @date: 2022/1/15 21:24
 * @description: 297. 二叉树的序列化与反序列化 https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Codec {

    String[] seq;
    int curr;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> seq = new ArrayList<>();
        dfs(seq,root);
        return String.join(",",seq);
    }

    public void dfs(List<String> seq,TreeNode root){
        if (root == null){
            seq.add("null");
            return;
        }
        seq.add(Integer.toString(root.val));
        dfs(seq,root.left);
        dfs(seq,root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        seq = data.split(",");
        curr = 0;
        return restore();
    }

    TreeNode restore(){
        if (seq[curr].equals("null")){
            curr ++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(seq[curr]));
        curr ++;
        root.left = restore();
        root.right = restore();
        return root;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();

    }


}
