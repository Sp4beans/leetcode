package com.sp4beans.leetcode.easy.solved;

//        给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
//
//        示例 :
//        给定二叉树
//
//              1
//             / \
//            2   3
//           / \
//          4   5
//        返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
//
//        注意：两结点之间的路径长度是以它们之间边的数目表示。

public class P543 {
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
        int result = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            findMaxPath(root);
            return result;
        }

        public int findMaxPath(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int maxLeft = findMaxPath(root.left);
            int maxRight = findMaxPath(root.right);
            result = Integer.max(result, maxLeft + maxRight);
            return Integer.max(maxLeft, maxRight) + 1;
        }
    }
}
