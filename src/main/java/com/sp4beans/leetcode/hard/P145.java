package com.sp4beans.leetcode.hard;

//        给定一个二叉树，返回它的 后序 遍历。
//
//        示例:
//
//        输入: [1,null,2,3]
//            1
//             \
//              2
//             /
//            3
//
//        输出: [3,2,1]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？

import java.util.ArrayList;
import java.util.List;

public class P145 {

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

        private List<Integer> ans = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            func(root);
            return ans;
        }

        public void func(TreeNode root) {
            if (null == root) return;
            func(root.left);
            func(root.right);
            ans.add(root.val);
        }
    }

}
