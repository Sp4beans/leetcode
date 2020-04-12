package com.sp4beans.leetcode.medium.solved;

//        给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
//
//        本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
//
//        示例:
//
//        给定的有序链表： [-10, -3, 0, 5, 9],
//
//        一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//              0
//             / \
//           -3   9
//           /   /
//         -10  5

import java.util.ArrayList;
import java.util.List;

public class P109 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            List<Integer> nodes = new ArrayList<>();
            while (null != head) {
                nodes.add(head.val);
                head = head.next;
            }

            Integer[] array = new Integer[nodes.size()];
            nodes.toArray(array);

            return gen(array, 0, array.length - 1);
        }

        public TreeNode gen(Integer[] array, int start, int end) {

            if (start > end) {
                return null;
            } else if (start == end) {
                return new TreeNode(array[start]);
            } else {
                int mid = (start + end) >> 1;
                TreeNode node = new TreeNode(array[mid]);
                node.left = gen(array, start, mid - 1);
                node.right = gen(array, mid + 1, end);
                return node;
            }
        }
    }
}
