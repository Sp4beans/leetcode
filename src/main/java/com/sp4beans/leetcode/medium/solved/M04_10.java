package com.sp4beans.leetcode.medium.solved;

//        检查子树。你有两棵非常大的二叉树：T1，有几万个节点；T2，有几万个节点。设计一个算法，判断 T2 是否为 T1 的子树。
//
//        如果 T1 有这么一个节点 n，其子树与 T2 一模一样，则 T2 为 T1 的子树，也就是说，从节点 n 处把树砍断，得到的树与 T2 完全相同。
//
//        示例1:
//
//        输入：t1 = [1, 2, 3], t2 = [2]
//        输出：true
//        示例2:
//
//        输入：t1 = [1, null, 2, 4], t2 = [3, 2]
//        输出：false
//        提示：
//
//        树的节点数目范围为[0, 20000]。

public class M04_10 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
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
        public boolean checkSubTree(TreeNode t1, TreeNode t2) {
            if (t2 == null) {
                return true;
            }
            if (t1 == null && t2 != null) {
                return false;
            }
            boolean isSubTree = false;
            if (t1.val == t2.val) {
                isSubTree = isSameTree(t1, t2);
            }
            if (isSubTree) {
                return true;
            } else {
                return checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
            }
        }

        private boolean isSameTree(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return true;
            }
            if (t1 == null || t2 == null) {
                return false;
            }
            if (t1.val == t2.val) {
                return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
            }
            return false;
        }
    }
}
