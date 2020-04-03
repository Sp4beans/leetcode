package com.sp4beans.leetcode.easy.solved;

//        给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回其自底向上的层次遍历为：
//
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]


import java.util.ArrayList;
import java.util.List;

public class P107 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            List<TreeNode> tir = new ArrayList<>();
            tir.add(root);

            while (null != tir && tir.size() > 0) {
                List<Integer> line = new ArrayList<>();
                List<TreeNode> newTir = new ArrayList<>();
                for (TreeNode node : tir) {
                    if (node == null) continue;
                    line.add(node.val);
                    if (null != node.left) newTir.add(node.left);
                    if (null != node.right) newTir.add(node.right);
                }
                tir = newTir;
                if (null != line && line.size() > 0) {
                    result.add(line);
                }
            }

            List<List<Integer>> ans = new ArrayList<>();
            for (int i = result.size() - 1; i >= 0; i--) {
                ans.add(result.get(i));
            }
            return ans;
        }
    }

}
