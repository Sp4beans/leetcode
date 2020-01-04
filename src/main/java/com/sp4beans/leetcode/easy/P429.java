package com.sp4beans.leetcode.easy;

//        给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
//        例如，给定一个 3叉树 :
//                  1
//               2  3  4
//              5 6
//
//
//
//         
//
//        返回其层序遍历:
//
//        [
//        [1],
//        [3,2,4],
//        [5,6]
//        ]
//         
//
//        说明:
//
//        树的深度不会超过 1000。
//        树的节点总数不会超过 5000。

import java.util.ArrayList;
import java.util.List;

public class P429 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            List<Node> roots = new ArrayList<>();
            roots.add(root);
            while (null != roots && roots.size() > 0) {
                List<Integer> curTir = new ArrayList<>();
                List<Node> newRoots = new ArrayList<>();
                for (Node node : roots) {
                    if (null == node) continue;
                    curTir.add(node.val);
                    if (null != node.children) {
                        newRoots.addAll(node.children);
                    }
                }
                roots = newRoots;
                if (null != curTir && curTir.size() > 0) {
                    result.add(curTir);
                }
            }
            return result;
        }
    }

}
