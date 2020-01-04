package com.sp4beans.leetcode.easy;

//        如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
//
//        只有给定的树是单值二叉树时，才返回 true；否则返回 false。
//
//         
//
//        示例 1：
//                  1
//              1       1
//            1   1       1
//
//
//        输入：[1,1,1,1,1,null,1]
//        输出：true
//        示例 2：
//                  2
//              2       2
//            5   2
//
//        输入：[2,2,2,5,2]
//        输出：false
//         
//
//        提示：
//
//        给定树的节点数范围是 [1, 100]。
//        每个节点的值都是整数，范围为 [0, 99] 。

public class P965 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public boolean isUnivalTree(TreeNode root) {
            if (null == root) {
                return true;
            }
            if (null != root.left && root.left.val != root.val) {
                return false;
            }
            if (null != root.right && root.right.val != root.val) {
                return false;
            }
            if (null != root.left && null != root.right && root.left.val != root.right.val) {
                return false;
            }
            return isUnivalTree(root.left) && isUnivalTree(root.right);
        }
    }
}
