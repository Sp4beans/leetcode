package com.sp4beans.leetcode.medium.solved;

//        给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
//
//        换句话说，第一个字符串的排列之一是第二个字符串的子串。
//
//        示例1:
//
//        输入: s1 = "ab" s2 = "eidbaooo"
//        输出: True
//        解释: s2 包含 s1 的排列之一 ("ba").
//         
//
//        示例2:
//
//        输入: s1= "ab" s2 = "eidboaoo"
//        输出: False
//         
//
//        注意：
//
//        输入的字符串只包含小写字母
//        两个字符串的长度都在 [1, 10,000] 之间

public class P567 {
    private static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int[] source = new int[26];
            for (char c : s1.toCharArray()) {
                source[c - 'a']++;
            }
            int[] target = new int[26];
            char[] tcs = s2.toCharArray();
            int startIdx = 0;
            int endIdx = 0;
            while (endIdx >= startIdx && endIdx <= tcs.length) {
                int result = compare(source, target);
                if (result == 0) {
                    return true;
                }
                if (result > 0) {
                    target[tcs[startIdx] - 'a']--;
                    startIdx++;
                } else {
                    if (endIdx < tcs.length) {
                        target[tcs[endIdx] - 'a']++;
                        endIdx++;
                    } else {
                        break;
                    }
                }
            }
            return false;
        }

        /**
         * 1 target多了
         * 0 一样
         * -1 target少了
         */
        public int compare(int[] source, int[] target) {
            int sameCnt = 0;
            for (int i = 0; i < 26; i++) {
                if (source[i] < target[i]) {
                    return 1;
                }
                if (source[i] == target[i]) {
                    sameCnt++;
                }
            }
            return sameCnt == 26 ? 0 : -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
        System.out.println(solution.checkInclusion("ab", "eidboaooo"));
        System.out.println(solution.checkInclusion("adc", "dcda"));
    }
}
