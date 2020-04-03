package com.sp4beans.leetcode.easy.solved;

//        给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
//
//        例如：
//
//        输入: 二叉搜索树:
//            5
//          /   \
//        2     13
//
//        输出: 转换为累加树:
//            18
//          /   \
//        20     13

public class P538 {
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
        int sum = 0;

        public TreeNode convertBST(TreeNode root) {

            backOrder(root);
            return root;
        }

        public void backOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            backOrder(root.right);
            root.val += sum;
            sum = root.val;
            backOrder(root.left);
        }
    }
}
