package com.sp4beans.leetcode.easy;

//        给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
//        注意：两个节点之间的路径长度由它们之间的边数表示。
//
//        示例 1:
//
//        输入:
//
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
//        输出:
//
//        2
//        示例 2:
//
//        输入:
//
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
//        输出:
//
//        2
//        注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。

public class P687 {

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
        int ans = 0;

        public int longestUnivaluePath(TreeNode root) {
            sameCount(root);
            return ans;
        }

        public int sameCount(TreeNode root) {

            if (null == root) {
                return 0;
            }

            int leftCount = sameCount(root.left);
            int rightCount = sameCount(root.right);

            int left = 0;
            int right = 0;
            if (null != root.left && root.left.val == root.val) {
                left += leftCount + 1;
            }
            if (null != root.right && root.right.val == root.val) {
                right += rightCount + 1;
            }

            ans = Integer.max(ans, left + right);
            return Integer.max(left, right);
        }

    }
}
