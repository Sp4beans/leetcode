package com.sp4beans.leetcode.medium.solved;

//        实现一个 MapSum 类里的两个方法，insert 和 sum。
//
//        对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
//
//        对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
//
//        示例 1:
//
//        输入: insert("apple", 3), 输出: Null
//        输入: sum("ap"), 输出: 3
//        输入: insert("app", 2), 输出: Null
//        输入: sum("ap"), 输出: 5

import java.util.Stack;

public class M677 {
    private static class MapSum {

        /** Initialize your data structure here. */
        class Node {
            Node[] childs = new Node[26];
            int val = 0;
            boolean isEnd = false;
            public Node() {
            }

            public Node(int val, boolean isEnd) {
                this.val = val;
                this.isEnd = isEnd;
            }
        }

        private Node root;

        public MapSum() {
            root = new Node();
        }

        public void insert(String key, int val) {
            char[] cs = key.toCharArray();
            Node cur = root;
            int idx = 0;
            while(idx < cs.length) {
                char ch = cs[idx];
                if (cur.childs[ch - 'a'] == null) {
                    cur.childs[ch - 'a'] = new Node();
                }
                cur = cur.childs[ch - 'a'];
                if (idx == cs.length - 1) {
                    cur.isEnd = true;
                    cur.val = val;
                }
                idx++;
            }
        }

        public int sum(String prefix) {
            char[] cs = prefix.toCharArray();
            Node cur = root;
            int idx = 0;
            while(idx < cs.length) {
                char ch = cs[idx];
                if (cur.childs[ch - 'a'] == null) {
                    cur = null;
                    break;
                }
                cur = cur.childs[ch - 'a'];
                idx++;
            }
            Stack<Node> stack = new Stack<>();
            int ans = 0;
            stack.push(cur);
            while (!stack.isEmpty()) {
                Node tmp = stack.pop();
                if (tmp == null) {
                    continue;
                }
                ans += tmp.val;
                for (Node node : tmp.childs) {
                    if (node != null) {
                        stack.push(node);
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        MapSum obj = new MapSum();
        obj.insert("apple", 3);
        System.out.println(obj.sum("app"));
        obj.insert("app", 2);
        System.out.println(obj.sum("ap"));
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
}
