package com.sp4beans.leetcode.easy.solved;

//        计算给定二叉树的所有左叶子之和。
//
//        示例：
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

public class P404 {
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
        public int sumOfLeftLeaves(TreeNode root) {
            if (null == root) {
                return 0;
            }
            return countVal(root.left, 0) + countVal(root.right, 1);
        }

        // type 0 for left
        // type 1 for right
        public int countVal(TreeNode root, int type) {
            if (null == root) {
                return 0;
            }
            if (type == 0 && (root.left == null && root.right == null)) {
                return root.val;
            } else {
                return countVal(root.left, 0) + countVal(root.right, 1);
            }
        }
    }
}
