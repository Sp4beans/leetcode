package com.sp4beans.leetcode.medium.solved;

//        实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
//        示例:
//
//        Trie trie = new Trie();
//
//        trie.insert("apple");
//        trie.search("apple");   // 返回 true
//        trie.search("app");     // 返回 false
//        trie.startsWith("app"); // 返回 true
//        trie.insert("app");
//        trie.search("app");     // 返回 true
//        说明:
//
//        你可以假设所有的输入都是由小写字母 a-z 构成的。
//        保证所有输入均为非空字符串。

public class P208 {
    private class Trie {

        class Node {
            boolean isEnd = false;
            Node[] childs = new Node[26];
        }

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] chs = word.toCharArray();
            Node cur = root;
            int idx = 0;
            while (idx < chs.length) {
                int childIdx = chs[idx] - 'a';
                if (cur.childs[childIdx] == null) {
                    cur.childs[childIdx] = new Node();
                }
                cur = cur.childs[childIdx];
                if (idx == chs.length - 1) {
                    cur.isEnd = true;
                }
                idx ++;
            }
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] chs = word.toCharArray();
            Node cur = root;
            int idx = 0;
            while (idx < chs.length) {
                int childIdx = chs[idx] - 'a';
                if (cur.childs[childIdx] == null) {
                    return false;
                }
                cur = cur.childs[childIdx];
                if (idx == chs.length - 1) {
                    return cur.isEnd;
                }
                idx ++;
            }
            return false;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] chs = prefix.toCharArray();
            Node cur = root;
            int idx = 0;
            while (idx < chs.length) {
                int childIdx = chs[idx] - 'a';
                if (cur.childs[childIdx] == null) {
                    return false;
                }
                cur = cur.childs[childIdx];
                idx ++;
            }
            return true;
        }
    }

    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
