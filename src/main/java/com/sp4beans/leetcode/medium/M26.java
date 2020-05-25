package com.sp4beans.leetcode.medium;

//        输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
//        B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
//        例如:
//        给定的树 A:
//
//             3
//            / \
//           4   5
//          / \
//         1   2
//        给定的树 B：
//
//           4 
//          /
//         1
//        返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
//        示例 1：
//
//        输入：A = [1,2,3], B = [3,1]
//        输出：false
//        示例 2：
//
//        输入：A = [3,4,5,1,2], B = [4,1]
//        输出：true
//        限制：
//
//        0 <= 节点个数 <= 10000

import java.util.ArrayList;
import java.util.List;

public class M26 {
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
        List<TreeNode> list = new ArrayList<>();
        public boolean isSubStructure(TreeNode A, TreeNode B) {
            if (B == null) {
                return A == null;
            }
            find(A, B);
            return list.isEmpty() ? false : list.stream().anyMatch(node -> isSame(node, B));
        }

        public boolean isSame(TreeNode A, TreeNode B) {
            if (A == null && B != null) {
                return false;
            }
            if (A.val != B.val) {
                return false;
            }
            if (B.left != null && B.right != null) {
                return isSame(A.left, B.left) && isSame(A.right, B.right);
            } else if (B.left == null && B.right != null) {
                return isSame(A.right, B.right);
            } else if (B.left != null && B.right == null) {
                return isSame(A.left, B.left);
            }
            return true;
        }

        public void find(TreeNode A, TreeNode B) {
            if (A.val == B.val) {
                list.add(A);
            }
            if (A.left != null) {
                find(A.left, B);
            }
            if (A.right != null) {
                find(A.right, B);
            }
        }
    }
}
