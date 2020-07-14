package com.sp4beans.leetcode.medium;

//        给你字符串 s 和整数 k 。
//
//        请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。
//
//        英文中的 元音字母 为（a, e, i, o, u）。
//
//         
//
//        示例 1：
//
//        输入：s = "abciiidef", k = 3
//        输出：3
//        解释：子字符串 "iii" 包含 3 个元音字母。
//        示例 2：
//
//        输入：s = "aeiou", k = 2
//        输出：2
//        解释：任意长度为 2 的子字符串都包含 2 个元音字母。
//        示例 3：
//
//        输入：s = "leetcode", k = 3
//        输出：2
//        解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
//        示例 4：
//
//        输入：s = "rhythms", k = 4
//        输出：0
//        解释：字符串 s 中不含任何元音字母。
//        示例 5：
//
//        输入：s = "tryhard", k = 4
//        输出：1
//         
//
//        提示：
//
//        1 <= s.length <= 10^5
//        s 由小写英文字母组成
//        1 <= k <= s.length

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class P1456 {
    private class Solution {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        public int maxVowels(String s, int k) {
            int startIdex = 0;
            int maxCount = 0;
            int curCount = 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (i < k) {
                    if (set.contains(cs[i])) {
                        curCount++;
                    }
                } else {
                    if (set.contains(cs[i])) {
                        curCount++;
                    }
                    if (set.contains(cs[startIdex++])) {
                        curCount--;
                    }
                }
                maxCount = Math.max(maxCount, curCount);
            }
            return maxCount;
        }
    }
}
