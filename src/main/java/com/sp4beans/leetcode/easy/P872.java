package com.sp4beans.leetcode.easy;

//        请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
//
//
//
//        举个例子，如上图所示，给定一颗叶值序列为 (6, 7, 4, 9, 8) 的树。
//
//        如果有两颗二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。
//
//        如果给定的两个头结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。
//
//         
//
//        提示：
//
//        给定的两颗树可能会有 1 到 100 个结点。

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P872 {

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
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {

            List<Integer> a = getVal(root1);
            List<Integer> b = getVal(root2);

            if (a.size() != b.size()) {
                return false;
            } else {
                for (int i = 0; i < a.size(); i++) {
                    if (a.get(i) != b.get(i)) {
                        return false;
                    }
                }
                return true;
            }
        }

        public List<Integer> getVal(TreeNode root) {
            List<Integer> list = new ArrayList<>();

            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (null == cur) {
                    continue;
                }
                if (cur.left == null && cur.right == null) {
                    list.add(cur.val);
                } else {
                    stack.add(cur.left);
                    stack.add(cur.right);
                }
            }

            return list;
        }
    }

}
