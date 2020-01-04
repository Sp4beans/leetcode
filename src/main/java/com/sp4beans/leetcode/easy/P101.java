package com.sp4beans.leetcode.easy;

//        给定一个二叉树，检查它是否是镜像对称的。
//
//        例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
//
//                  1
//                 / \
//                2   2
//               / \ / \
//              3  4 4  3
//        但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
//
//                  1
//                 / \
//                2   2
//                 \   \
//                 3    3
//        说明:
//
//        如果你可以运用递归和迭代两种方法解决这个问题，会很加分。

public class P101 {
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
        public boolean isSymmetric(TreeNode root) {
            if (null == root) {
                return true;
            }
            return isMirror(root.left, root.right);
        }

        public boolean isMirror(TreeNode a, TreeNode b) {
            if (null == a && null == b) {
                return true;
            }
            if (null == a || null == b) {
                return false;
            }

            if (a.val != b.val) {
                return false;
            }

            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }

    }
}
