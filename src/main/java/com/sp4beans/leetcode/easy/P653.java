package com.sp4beans.leetcode.easy;

//        给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。
//
//        案例 1:
//
//        输入:
//              5
//             / \
//            3   6
//           / \   \
//          2   4   7
//
//        Target = 9
//
//        输出: True
//         
//
//        案例 2:
//
//        输入:
//              5
//             / \
//            3   6
//           / \   \
//          2   4   7
//
//        Target = 28
//
//        输出: False

import java.util.LinkedList;
import java.util.Queue;

public class P653 {

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
        public boolean findTarget(TreeNode root, int k) {

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode cur = queue.poll();
                int val = cur.val;
                if (find(root, k - val) && k - val != val) {
                    return true;
                }
                if (null != cur.left) queue.add(cur.left);
                if (null != cur.right) queue.add(cur.right);
            }
            return false;
        }

        public boolean find(TreeNode root, int target) {
            if (null == root) {
                return false;
            }
            if (target == root.val) {
                return true;
            } else if (target < root.val) {
                return find(root.left, target);
            } else {
                return find(root.right, target);
            }
        }
    }

}
