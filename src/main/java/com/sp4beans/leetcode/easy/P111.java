package com.sp4beans.leetcode.easy;

//        给定一个二叉树，找出其最小深度。
//
//        最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
//
//        说明: 叶子节点是指没有子节点的节点。
//
//        示例:
//
//        给定二叉树 [3,9,20,null,null,15,7],
//
//              3
//             / \
//            9  20
//           /  \
//          15   7
//        返回它的最小深度  2.

import java.util.ArrayList;
import java.util.List;

public class P111 {

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
        public int minDepth(TreeNode root) {
            if (null == root) {
                return 0;
            }
            int ans = 0;
            List<TreeNode> level = new ArrayList<>();
            level.add(root);

            while (null != level && level.size() > 0) {
                ans++;
                List<TreeNode> temp = new ArrayList<>();
                for (TreeNode node : level) {
                    if (node.left == null && node.right == null) {
                        return ans;
                    }
                    if (null != node.left) {
                        temp.add(node.left);
                    }
                    if (null != node.right) {
                        temp.add(node.right);
                    }
                }
                level = temp;
            }

            return ans;

        }
    }
}
