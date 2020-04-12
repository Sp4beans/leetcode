package com.sp4beans.leetcode.medium.solved;

//        给定一个二叉树，返回它的 前序 遍历。
//
//         示例:
//
//        输入: [1,null,2,3]
//        1
//         \
//          2
//         /
//        3
//
//        输出: [1,2,3]
//        进阶: 递归算法很简单，你可以通过迭代算法完成吗？

import java.util.ArrayList;
import java.util.List;

public class P144 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Solution {

        List<Integer> result = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            helper(root);
            return result;
        }

        public void helper(TreeNode root) {
            if (root == null) {
                return ;
            }
            result.add(root.val);
            helper(root.left);
            helper(root.right);
        }
    }

}
