package com.sp4beans.leetcode.medium.solved;

//        给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
//
//        示例:
//
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出:
//        [
//        ["ate","eat","tea"],
//        ["nat","tan"],
//        ["bat"]
//        ]
//        说明：
//
//        所有输入均为小写字母。
//        不考虑答案输出的顺序。

import static java.util.stream.Collectors.groupingBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P49 {
    private class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            return Arrays.stream(strs).collect(groupingBy(this::convert)).values().stream()
                    .collect(Collectors.toList());
        }

        public String convert(String str) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }
    }
}
