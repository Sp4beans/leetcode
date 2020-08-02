package com.sp4beans.leetcode.medium.solved;

//        给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
//
//        示例:
//
//        输入: [1,2,3,null,5,null,4]
//        输出: [1, 3, 4]
//        解释:
//
//              1            <---
//            /   \
//           2     3         <---
//            \     \
//             5     4       <---

import java.util.ArrayList;
import java.util.List;

public class P199 {
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
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            List<TreeNode> layer = new ArrayList<>();
            layer.add(root);
            while (layer.size() > 0) {
                List<TreeNode> newLayer = new ArrayList<>();
                TreeNode last = null;
                for (TreeNode node : layer) {
                    if (node != null) {
                        last = node;
                        newLayer.add(last.left);
                        newLayer.add(last.right);
                    }
                }
                if (last != null) {
                    result.add(last.val);
                }
                layer = newLayer;
            }

            return result;
        }
    }

}
