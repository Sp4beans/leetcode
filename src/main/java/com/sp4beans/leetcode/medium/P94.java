package com.sp4beans.leetcode.medium;

//        给定一个二叉树，返回它的中序 遍历。
//
//        示例:
//
//        输入: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//
//        输出: [1,3,2]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？

import java.util.ArrayList;
import java.util.List;

public class P94 {
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
        List<Integer> ans = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            inOrder(root);
            return ans;
        }

        public void inOrder(TreeNode root) {
            if (null == root) {
                return;
            }
            inOrder(root.left);
            ans.add(root.val);
            inOrder(root.right);
        }
    }
}
