package com.sp4beans.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

//        给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
//
//        示例 :
//
//        输入:
//
//          1
//           \
//            3
//           /
//          2
//
//        输出:
//        1
//
//        解释:
//        最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
//        注意: 树中至少有2个节点。

public class P530 {

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
        List<Integer> list = new ArrayList<>();

        public int getMinimumDifference(TreeNode root) {
            search(root);
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < list.size(); i++) {
                min = Integer.min(list.get(i) - list.get(i - 1), min);
            }
            return min;
        }

        public void search(TreeNode node) {
            if (node == null) return;
            search(node.left);
            list.add(node.val);
            search(node.right);
        }
    }
}
