package com.sp4beans.leetcode.medium;

//        给定一个二叉树，在树的最后一行找到最左边的值。
//
//        示例 1:
//
//        输入:
//
//              2
//             / \
//            1   3
//
//        输出:
//        1
//         
//
//        示例 2:
//
//        输入:
//
//              1
//             / \
//            2   3
//           /   / \
//          4   5   6
//             /
//            7
//
//        输出:
//        7

public class P513 {
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
        int maxdepth = 0;
        TreeNode ans = null;

        public int findBottomLeftValue(TreeNode root) {
            preorder(root, 1);
            return ans.val;
        }

        public void preorder(TreeNode root, int depth) {
            if (null == root) return;
            if (null == root.left && null == root.right && depth > maxdepth) {
                maxdepth = depth;
                ans = root;
            }

            preorder(root.left, depth + 1);
            preorder(root.right, depth + 1);
        }
    }
}
