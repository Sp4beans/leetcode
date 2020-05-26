package com.sp4beans.leetcode.medium.solved;

//        请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
//         
//
//        例如:
//        给定二叉树: [3,9,20,null,null,15,7],
//
//              3
//             / \
//            9  20
//              /  \
//             15   7
//        返回其层次遍历结果：
//
//        [
//        [3],
//        [20,9],
//        [15,7]
//        ]
//         
//
//        提示：
//
//        节点总数 <= 1000

import java.util.ArrayList;
import java.util.List;

public class M32III {
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
        public List<List<Integer>> levelOrder(TreeNode root) {
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
