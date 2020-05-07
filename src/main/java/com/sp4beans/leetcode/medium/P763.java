package com.sp4beans.leetcode.medium;

//        字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
//
//        示例 1:
//
//        输入: S = "ababcbacadefegdehijhklij"
//        输出: [9,7,8]
//        解释:
//        划分结果为 "ababcbaca", "defegde", "hijhklij"。
//        每个字母最多出现在一个片段中。
//        像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
//        注意:
//
//        S的长度在[1, 500]之间。
//        S只包含小写字母'a'到'z'。

import java.util.ArrayList;
import java.util.List;

public class P763 {
    private class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] first = new int[27];
            int[] last = new int[27];
            for (char c = 'a'; c <= 'z'; c++) {
                first[c - 'a'] = S.indexOf(c);
                last[c - 'a'] = S.lastIndexOf(c);
            }
            List<Integer> result = new ArrayList<>();
            char[] cs = S.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                int startIndex = i;
                int endIndex = last[c - 'a'];
                int curIndex = startIndex + 1;
                while (curIndex < endIndex) {
                    char tmp = cs[curIndex];
                    int tmpIndex = last[tmp - 'a'];
                    if (tmpIndex > endIndex) {
                        endIndex = tmpIndex;
                    }
                    curIndex++;
                }
                result.add(endIndex - startIndex + 1);
                i = endIndex;
            }
            return result;
        }
    }
}
