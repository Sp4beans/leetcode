package com.sp4beans.leetcode.medium;

//        给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//        例如：
//        给定二叉树 [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        返回锯齿形层次遍历如下：
//
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]

import java.util.ArrayList;
import java.util.List;

public class P103 {
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            List<TreeNode> temp = new ArrayList<>();
            temp.add(root);
            boolean odd = true;
            while (temp != null && temp.size() > 0) {
                List<Integer> item = new ArrayList<>();
                int size = temp.size();
                for (int i = 0; i < size; i++) {
                    item.add(odd ? temp.get(i).val : temp.get(size - i - 1).val);
                }
                result.add(item);
                odd = !odd;
                List<TreeNode> newTemp = new ArrayList<>();
                for (TreeNode node : temp) {
                    if (node.left != null) {
                        newTemp.add(node.left);
                    }
                    if (node.right != null) {
                        newTemp.add(node.right);
                    }
                }
                temp = newTemp;
            }
            return result;
        }
    }
}
