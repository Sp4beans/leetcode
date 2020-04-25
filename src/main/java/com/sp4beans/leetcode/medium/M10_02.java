package com.sp4beans.leetcode.medium;

//        编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
//
//        注意：本题相对原题稍作修改
//
//        示例:
//
//        输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class M10_02 {
    private class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String key = convert(str);
                if (map.containsKey(key)) {
                    map.get(key).add(str);
                } else {
                    List<String> item = new ArrayList<>();
                    item.add(str);
                    map.put(key, item);
                }
            }

            return map.values().stream().collect(Collectors.toList());
        }

        private String convert(String source) {
            char[] cs = source.toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }

    }
}
