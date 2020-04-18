package com.sp4beans.leetcode.medium.solved;

//        给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
//
//         
//
//        示例：
//
//        输入：[1,2,3,4,5,null,7,8]
//
//        1
//        /  \
//        2    3
//        / \    \
//        4   5    7
//        /
//        8
//
//        输出：[[1],[2,3],[4,5,7],[8]]

import java.util.ArrayList;
import java.util.List;

public class M04_03 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
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

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public ListNode[] listOfDepth(TreeNode tree) {
            List<ListNode> ans = new ArrayList<>();
            if (tree != null) {
                List<TreeNode> tmp = new ArrayList<>();
                tmp.add(tree);
                while (!tmp.isEmpty()) {
                    ListNode dummy = new ListNode(-1);
                    ListNode pre = dummy;
                    List<TreeNode> newTmp = new ArrayList<>();
                    for (TreeNode treeNode : tmp) {
                        ListNode cur = new ListNode(treeNode.val);
                        pre.next = cur;
                        pre = cur;
                        if (treeNode.left != null) {
                            newTmp.add(treeNode.left);
                        }
                        if (treeNode.right != null) {
                            newTmp.add(treeNode.right);
                        }
                    }
                    ans.add(dummy.next);
                    tmp = newTmp;
                }
            }

            ListNode[] result = new ListNode[ans.size()];
            result = ans.toArray(result);
            return result;
        }
    }
}
