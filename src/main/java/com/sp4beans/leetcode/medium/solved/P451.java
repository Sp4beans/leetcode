package com.sp4beans.leetcode.medium.solved;

//        给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
//        示例 1:
//
//        输入:
//        "tree"
//
//        输出:
//        "eert"
//
//        解释:
//        'e'出现两次，'r'和't'都只出现一次。
//        因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//        示例 2:
//
//        输入:
//        "cccaaa"
//
//        输出:
//        "cccaaa"
//
//        解释:
//        'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//        注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//        示例 3:
//
//        输入:
//        "Aabb"
//
//        输出:
//        "bbAa"
//
//        解释:
//        此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//        注意'A'和'a'被认为是两种不同的字符。

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class P451 {
    private static class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> countMap = new HashMap<>();
            char[] cs = s.toCharArray();
            for (char c : cs) {
                if (countMap.containsKey(c)) {
                    countMap.put(c, countMap.get(c) + 1);
                } else {
                    countMap.put(c, 1);
                }
            }

            List<Map.Entry<Character, Integer>> entryList = new ArrayList(countMap.entrySet());
            Collections.sort(entryList, Map.Entry.comparingByValue());

            StringBuilder sb = new StringBuilder();
            for (int i = entryList.size() - 1; i >= 0; i--) {
                Entry<Character, Integer> entry = entryList.get(i);
                for (int j = 0; j < entry.getValue(); j++) {
                    sb.append(entry.getKey());
                }
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.frequencySort("tree"));
        System.out.println(solution.frequencySort("cccaaa"));
        System.out.println(solution.frequencySort("Aabb"));
    }
}
