package com.sp4beans.leetcode.easy.solved;

//        给定一个二叉树，它的每个结点都存放着一个整数值。
//
//        找出路径和等于给定数值的路径总数。
//
//        路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
//
//        二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
//
//        示例：
//
//        root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
//
//              10
//             /  \
//            5   -3
//           / \    \
//          3   2   11
//         / \   \
//        3  -2   1
//
//        返回 3。和等于 8 的路径有:
//
//        1.  5 -> 3
//        2.  5 -> 2 -> 1
//        3.  -3 -> 11

//        1:3
//        2:2
//        3:0
//        4:-3
//        5:-7
//        5:3
//        4:3
//        5:-1
//        5:3
//        3:3
//        4:0
//        5:-4
//        5:3
//        4:3
//        5:-1
//        5:3
//        2:3
//        3:1
//        4:-2
//        5:-6
//        5:3
//        4:3
//        5:-1
//        5:3
//        3:3
//        4:0
//        5:-4
//        5:3
//        4:3
//        5:-1
//        5:3

public class P437 {

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
        public int pathSum(TreeNode root, int sum) {
            if (null == root) {
                return 0;
            }
            return find(root, sum, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        }


        public int find(TreeNode root, int target, int sum) {
            if (null == root) {
                return 0;
            }

            int result = 0;
            if (root.val == target) {
                result = 1;
            }
            return result + find(root.left, target - root.val, sum) + find(root.right, target - root.val, sum);
        }
    }
}
