package com.sp4beans.leetcode.easy;

//        输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
//
//        例如：
//
//        给定二叉树 [3,9,20,null,null,15,7]，
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回它的最大深度 3 。
//
//         
//
//        提示：
//
//        节点总数 <= 10000
//        注意：本题与主站 104 题相同

public class M55I {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class Solution {
        public int maxDepth(TreeNode root) {
            if (null == root) {
                return 0;
            } else {
                return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
            }
        }
    }
}
