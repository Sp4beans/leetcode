package com.sp4beans.leetcode.medium;

//        你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
//
//         
//
//        示例 1：
//
//        输入："AAB"
//        输出：8
//        解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
//        示例 2：
//
//        输入："AAABBC"
//        输出：188
//         
//
//        提示：
//
//        1 <= tiles.length <= 7
//        tiles 由大写英文字母组成

public class P1079 {
    private static class Solution {

        public int numTilePossibilities(String tiles) {
            char[] cs = tiles.toCharArray();
            int[] counter = new int[26];
            for (char c : cs) {
                counter[c - 'A']++;
            }

            return backtrack(counter);
        }

        public int backtrack(int[] counter) {
            int ans = 0;
            for (int i = 0; i < counter.length; i++) {
                if (counter[i] > 0) {
                    counter[i]--;
                    ans++;
                    ans += backtrack(counter);
                    counter[i]++;
                }
            }
            return ans;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
        System.out.println(solution.numTilePossibilities("AAABBC"));
    }
}
