package com.sp4beans.leetcode.medium.solved;

//        给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
//
//        例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
//
//        对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
//
//        那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
//
//         
//
//        示例：
//
//        输入: words = ["time", "me", "bell"]
//        输出: 10
//        说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
//         
//
//        提示：
//
//        1 <= words.length <= 2000
//        1 <= words[i].length <= 7
//        每个单词都是小写字母 。

import java.util.ArrayList;
import java.util.List;

public class P820 {

    private class Solution {
        private class TriNode {
            TriNode[] children = new TriNode[26];
            TriNode() {
            }
        }

        TriNode root = new TriNode();
        List<Integer> countList = new ArrayList<>();

        public int minimumLengthEncoding(String[] words) {
            for (String word : words) {
                buildTri(word);
            }
            count(root, 1);
            int ans = 0;
            for (int i : countList) {
                ans += i;
            }
            return ans;
        }

        private void count(TriNode root, int curLen) {
            if (root == null) {
                if (curLen != 0) {
                    countList.add(curLen);
                }
                return;
            }
            boolean hasChild = false;
            for (TriNode node : root.children) {
                if (node != null) {
                    hasChild = true;
                    count(node, curLen + 1);
                }
            }
            if (!hasChild) {
                countList.add(curLen);
            }
        }


        private void buildTri(String word) {
            char[] cs = word.toCharArray();
            TriNode cur = root;
            for (int i = cs.length - 1; i >= 0; i--) {
                if (cur.children[cs[i] - 'a'] == null) {
                    cur.children[cs[i] - 'a'] = new TriNode();
                }
                cur = cur.children[cs[i] - 'a'];
            }
        }
    }
}
