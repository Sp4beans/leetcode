package com.sp4beans.leetcode.medium;

//        实现一个函数，检查一棵二叉树是否为二叉搜索树。
//
//        示例 1:
//        输入:
//        2
//        / \
//        1   3
//        输出: true
//        示例 2:
//        输入:
//        5
//        / \
//        1   4
//             / \
//            3   6
//        输出: false
//        解释: 输入为: [5,1,4,null,null,3,6]。
//             根节点的值为 5 ，但是其右子节点值为 4 。

public class M04_05 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public boolean isValidBST(TreeNode root) {
            // TODO
            return false;
        }
    }
}