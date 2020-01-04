package com.sp4beans.leetcode.easy;

//        给定一个二叉树，判断它是否是高度平衡的二叉树。
//
//        本题中，一棵高度平衡二叉树定义为：
//
//        一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
//
//        示例 1:
//
//        给定二叉树 [3,9,20,null,null,15,7]
//
//              3
//             / \
//            9  20
//              /  \
//             15   7
//        返回 true 。
//
//        示例 2:
//
//        给定二叉树 [1,2,2,3,3,null,null,4,4]
//
//                1
//               / \
//              2   2
//             / \
//            3   3
//           / \
//          4   4
//        返回 false 。

public class P110 {
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

    private static class Solution {
        public boolean isBalanced(TreeNode root) {
            return depth(root) != -1;
        }

        private int depth(TreeNode root) {
            if (root == null) return 0;
            int left = depth(root.left);
            if (left == -1) return -1;
            int right = depth(root.right);
            if (right == -1) return -1;
            return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
        }

//        public boolean isBalanced(TreeNode root) {
//            if (null == root) {
//                return true;
//            }
//            return Math.abs(countHeight(root.left) - countHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
//        }
//
//        public int countHeight(TreeNode root) {
//            if (null == root) {
//                return 0;
//            } else {
//                return 1 + Integer.max(countHeight(root.left), countHeight(root.right));
//            }
//        }
    }
}
