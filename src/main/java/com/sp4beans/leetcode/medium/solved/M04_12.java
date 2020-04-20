package com.sp4beans.leetcode.medium.solved;

//        给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        返回:
//
//        3
//        解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7]
//        提示：
//
//        节点总数 <= 10000

public class M04_12 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
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
        int count = 0;
        public int pathSum(TreeNode root, int sum) {
            fun(root, sum);
            return count;
        }

        private void fun(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            fun(root.left, sum);
            helper(root, sum);
            fun(root.right, sum);
        }

        private void helper(TreeNode root, int sum) {
            if (root == null) {
                return;
            }

            if (root.val == sum) {
                count++;
            }

            helper(root.left, sum - root.val);
            helper(root.right, sum - root.val);
        }
    }
}
