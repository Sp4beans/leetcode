package com.sp4beans.leetcode.easy.solved;

//        给定一个 N 叉树，返回其节点值的后序遍历。
//
//        例如，给定一个 3叉树 :
//                          1
//                  3       2       4
//              5       6
//
//
//         
//
//        返回其后序遍历:[5,6,3,2,4,1].
//
//         
//
//        说明: 递归法很简单，你可以使用迭代法完成此题吗?


import java.util.ArrayList;
import java.util.List;

public class P590 {
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
        public List<Integer> postorder(Node root) {
            List<Integer> result = new ArrayList<>();
            if (null == root) {
                return result;
            }
            List<Node> children = root.children;
            if (null != children && children.size() > 0) {
                for (Node node : children) {
                    result.addAll(postorder(node));
                }
            }
            result.add(root.val);
            return result;
        }
    }
}
