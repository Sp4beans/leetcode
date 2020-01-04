package com.sp4beans.leetcode.easy;

//        给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
//
//        示例 1:
//        给定的树 s:
//
//              3
//             / \
//            4   5
//           / \
//          1   2
//        给定的树 t：
//
//            4
//           / \
//          1   2
//        返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
//
//        示例 2:
//        给定的树 s：
//
//              3
//             / \
//            4   5
//           / \
//          1   2
//         /
//        0
//        给定的树 t：
//
//          4
//         / \
//        1   2
//        返回 false。

public class P572 {
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
        TreeNode rawT;

        public boolean isSubtree(TreeNode s, TreeNode t) {
            rawT = t;

            return isSame(s, t);
        }

        public boolean isSame(TreeNode s, TreeNode t) {
            if (null == s && null == t) {
                return true;
            }
            if (null != s && null != t) {
                if (s.val == t.val) {
                    return (isSame(s.left, t.left) && isSame(s.right, t.right)) || isSame(s.left, t) || isSame(s.right, t);
                } else {
                    return isSame(s.left, rawT) || isSame(s.right, rawT);
                }
            }
            return false;
        }
    }
}
