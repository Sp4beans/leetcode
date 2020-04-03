package com.sp4beans.leetcode.easy.solved;

//        给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。
//
//         
//
//        示例 1：
//
//        输入： A = "ab", B = "ba"
//        输出： true
//        示例 2：
//
//        输入： A = "ab", B = "ab"
//        输出： false
//        示例 3:
//
//        输入： A = "aa", B = "aa"
//        输出： true
//        示例 4：
//
//        输入： A = "aaaaaaabc", B = "aaaaaaacb"
//        输出： true
//        示例 5：
//
//        输入： A = "", B = "aa"
//        输出： false
//         
//
//        提示：
//
//        0 <= A.length <= 20000
//        0 <= B.length <= 20000
//        A 和 B 仅由小写字母构成。

public class P859 {
    private static class Solution {
        public boolean buddyStrings(String A, String B) {
            if (A.length() != B.length()) {
                return false;
            } else {
                if (A.equals(B)) {
                    return hasSame(A, B);
                } else {
                    return (diffCount(A, B) == 2 && isSameChars(A, B)) || (diffCount(A, B) == 0 && hasSame(A, B));
                }
            }
        }

        public boolean hasSame(String a, String b) {
            int[] count = new int[26];
            int maxCount = 0;
            for (char c : a.toCharArray()) {
                count[c - 'a']++;
                maxCount = Integer.max(maxCount, count[c - 'a']);
            }
            return maxCount >= 2;
        }

        public boolean isSameChars(String a, String b) {
            int[] countA = new int[26];
            int[] countB = new int[26];
            for (char c : a.toCharArray()) {
                countA[c - 'a']++;
            }
            for (char c : b.toCharArray()) {
                countB[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                if (countA[i] != countB[i]) {
                    return false;
                }
            }
            return true;
        }

        public int diffCount(String a, String b) {
            if (a.length() == b.length()) {
                int count = 0;
                for (int i = 0; i < a.length(); i++) {
                    if (a.charAt(i) != b.charAt(i)) {
                        count++;
                    }
                }
                return count;
            } else {
                return -1;
            }

        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.buddyStrings("ab", "ba"));
        System.out.println(solution.buddyStrings("ab", "ab"));
        System.out.println(solution.buddyStrings("aa", "aa"));
        System.out.println(solution.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(solution.buddyStrings("", "aa"));
        System.out.println(solution.buddyStrings("abcaa", "abcbb"));
    }
}
