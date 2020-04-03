package com.sp4beans.leetcode.easy.solved;

//        给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么这个节点的值不大于它的子节点的值。 
//
//        给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
//
//        示例 1:
//
//        输入:
//               2
//              / \
//             2   5
//            / \
//           5   7
//
//        输出: 5
//        说明: 最小的值是 2 ，第二小的值是 5 。
//        示例 2:
//
//        输入:
//          2
//         / \
//        2   2
//
//        输出: -1
//        说明: 最小的值是 2, 但是不存在第二小的值。

public class P671 {
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
        public int findSecondMinimumValue(TreeNode root) {
            if (null == root || null == root.left || null == root.right) {
                return -1;
            }
            int leftMin = findSecondMinimumValue(root.left);
            int rightMin = findSecondMinimumValue(root.right);
            if (root.left.val != root.val && root.right.val != root.val) {
                return Integer.min(root.left.val, root.right.val);
            }
            if (root.left.val != root.val) {
                if (rightMin != -1) {
                    return Integer.min(root.left.val, rightMin);
                } else {
                    return root.left.val;
                }
            }
            if (root.right.val != root.val) {
                if (leftMin != -1) {
                    return Integer.min(root.right.val, leftMin);
                } else {
                    return root.right.val;
                }
            }

            if (leftMin == -1 && rightMin == -1) {
                return -1;
            } else if (leftMin == -1) {
                return rightMin;
            } else if (rightMin == -1) {
                return leftMin;
            } else
                return Integer.min(leftMin, rightMin);
        }
    }
}
