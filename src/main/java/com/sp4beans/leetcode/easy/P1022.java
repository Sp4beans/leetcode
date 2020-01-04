package com.sp4beans.leetcode.easy;

//        给出一棵二叉树，其上每个结点的值都是 0 或 1 。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。例如，如果路径为 0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数 01101，也就是 13 。
//
//        对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。
//
//        以 10^9 + 7 为模，返回这些数字之和。
//
//         
//
//        示例：
//
//
//
//        输入：[1,0,1,0,1,0,1]
//        输出：22
//        解释：(100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
//         
//
//        提示：
//
//        树中的结点数介于 1 和 1000 之间。
//        node.val 为 0 或 1 。

public class P1022 {
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
        int mod = 1000000007;
        int ans = 0;

        public int sumRootToLeaf(TreeNode root) {
            helper(root, 0);
            return ans;
        }

        public void helper(TreeNode root, int curVal) {
            if (null == root) {
                return;
            }

            curVal = ((curVal << 1) + root.val) % mod;
            if (root.left == null && root.right == null) {
                ans = (ans + curVal) % mod;
            }
            helper(root.left, curVal);
            helper(root.right, curVal);
        }
    }
}