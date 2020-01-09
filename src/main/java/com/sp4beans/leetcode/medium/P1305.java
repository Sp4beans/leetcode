package com.sp4beans.leetcode.medium;

//        给你 root1 和 root2 这两棵二叉搜索树。
//
//        请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
//
//         
//
//        示例 1：
//
//
//
//        输入：root1 = [2,1,4], root2 = [1,0,3]
//        输出：[0,1,1,2,3,4]
//        示例 2：
//
//        输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//        输出：[-10,0,0,1,2,5,7,10]
//        示例 3：
//
//        输入：root1 = [], root2 = [5,1,7,0,2]
//        输出：[0,1,2,5,7]
//        示例 4：
//
//        输入：root1 = [0,-10,10], root2 = []
//        输出：[-10,0,10]
//        示例 5：
//
//
//
//        输入：root1 = [1,null,8], root2 = [8,1]
//        输出：[1,1,8,8]
//         
//
//        提示：
//
//        每棵树最多有 5000 个节点。
//        每个节点的值在 [-10^5, 10^5] 之间。

import java.util.ArrayList;
import java.util.List;

public class P1305 {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            helper(root1, list1);
            helper(root2, list2);

            List<Integer> result = new ArrayList<>();
            int index1 = 0;
            int index2 = 0;

            while (index1 < list1.size() && index2 < list2.size()) {
                int a = list1.get(index1);
                int b = list2.get(index2);
                if (a < b) {
                    result.add(a);
                    index1++;
                } else {
                    result.add(b);
                    index2++;
                }
            }

            while (index1 < list1.size()) {
                result.add(list1.get(index1));
                index1++;
            }

            while (index2 < list2.size()) {
                result.add(list2.get(index2));
                index2++;
            }

            return result;
        }

        public void helper(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }
}
