package com.sp4beans.leetcode.easy.solved;

//        给定两个二叉树，编写一个函数来检验它们是否相同。
//
//        如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
//
//        示例 1:
//
//        输入:       1         1
//        / \       / \
//        2   3     2   3
//
//        [1,2,3],   [1,2,3]
//
//        输出: true
//        示例 2:
//
//        输入:      1          1
//        /           \
//        2             2
//
//        [1,2],     [1,null,2]
//
//        输出: false
//        示例 3:
//
//        输入:       1         1
//        / \       / \
//        2   1     1   2
//
//        [1,2,1],   [1,1,2]
//
//        输出: false

public class P100 {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (null == p && null == q) {
                return true;
            }
            if (null == p || null == q) {
                return false;
            }
            if (p.val == q.val) {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            } else {
                return false;
            }
        }
    }
}
