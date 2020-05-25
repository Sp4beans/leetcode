package com.sp4beans.leetcode.medium;

//        输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
//
//         
//
//        示例:
//        给定如下二叉树，以及目标和 sum = 22，
//
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        返回:
//
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
//         
//
//        提示：
//
//        节点总数 <= 10000
//        注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/

import java.util.ArrayList;
import java.util.List;

public class P113 {
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
        int curSum = 0;
        List<Integer> cur;
        List<List<Integer>> result;

        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            cur = new ArrayList<>();
            result = new ArrayList<>();
            addNode(root);
            helper(root, sum);
            return result;
        }

        private void helper(TreeNode root, int target) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                if (curSum == target) {
                    List<Integer> dist = new ArrayList<>();
                    dist.addAll(cur);
                    result.add(dist);
                }
                return;
            }
            if (root.left != null) {
                addNode(root.left);
                helper(root.left, target);
                removeNode(root.left);
            }

            if (root.right != null) {
                addNode(root.right);
                helper(root.right, target);
                removeNode(root.right);
            }

        }

        private void addNode(TreeNode node) {
            if (node != null) {
                cur.add(node.val);
                curSum += node.val;
            }
        }

        private void removeNode(TreeNode node) {
            if (node != null) {
                cur.remove(cur.size() - 1);
                curSum -= node.val;
            }
        }
    }

}
