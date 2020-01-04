package com.sp4beans.leetcode.easy;

//        给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
//
//        示例 1:
//
//        输入:
//        3
//        / \
//        9  20
//        /  \
//        15   7
//        输出: [3, 14.5, 11]
//        解释:
//        第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
//        注意：
//
//        节点值的范围在32位有符号整数范围内。

import java.util.ArrayList;
import java.util.List;

public class P637 {
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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> result = new ArrayList<>();
            List<TreeNode> tir = new ArrayList<>();
            tir.add(root);
            while (null != tir && tir.size() > 0) {
                double sum = 0;
                int count = 0;
                List<TreeNode> newTir = new ArrayList<>();
                for (TreeNode node : tir) {
                    if (null == node) {
                        continue;
                    }
                    sum += node.val;
                    count++;
                    if (null != node.left) newTir.add(node.left);
                    if (null != node.right) newTir.add(node.right);
                }
                if (count != 0) {
                    result.add(sum / count);
                }
                tir = newTir;
            }
            return result;
        }
    }
}
