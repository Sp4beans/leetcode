package com.sp4beans.leetcode.easy.solved;

//        在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
//
//        如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。
//
//        我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。
//
//        只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
//
//         
//
//        示例 1：
//
//
//        输入：root = [1,2,3,4], x = 4, y = 3
//        输出：false
//        示例 2：
//
//
//        输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
//        输出：true
//        示例 3：
//
//
//
//        输入：root = [1,2,3,null,4], x = 2, y = 3
//        输出：false
//         
//
//        提示：
//
//        二叉树的节点数介于 2 到 100 之间。
//        每个节点的值都是唯一的、范围为 1 到 100 的整数。

public class P993 {
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

        int parentX = -1;
        int parentY = -1;
        int levelX = -1;
        int levelY = -1;

        public boolean isCousins(TreeNode root, int x, int y) {
            if (null == root) {
                return false;
            }
            help(root, x, 0, true, -1);
            help(root, y, 0, false, -1);
            return levelX == levelY && parentY != parentX;
        }

        public void help(TreeNode root, int target, int curLevel, boolean x, int lastNodeVal) {
            if (null == root) {
                return;
            }
            if (root.val == target) {
                if (x) {
                    levelX = curLevel;
                    parentX = lastNodeVal;
                } else {
                    levelY = curLevel;
                    parentY = lastNodeVal;
                }
            } else {
                help(root.left, target, curLevel + 1, x, root.val);
                help(root.right, target, curLevel + 1, x, root.val);
            }
        }


    }
}
