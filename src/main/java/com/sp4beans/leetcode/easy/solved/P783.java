package com.sp4beans.leetcode.easy.solved;

//        给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
//
//        示例：
//
//        输入: root = [4,2,6,1,3,null,null]
//        输出: 1
//        解释:
//        注意，root是树结点对象(TreeNode object)，而不是数组。
//
//        给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//                  4
//                /   \
//               2      6
//              / \
//             1   3
//
//        最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
//        注意：
//
//        二叉树的大小范围在 2 到 100。
//        二叉树总是有效的，每个节点的值都是整数，且不重复。

import java.util.ArrayList;
import java.util.List;

public class P783 {

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

        public int minDiffInBST(TreeNode root) {
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
