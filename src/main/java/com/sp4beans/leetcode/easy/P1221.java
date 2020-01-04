package com.sp4beans.leetcode.easy;

//        在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
//
//        给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
//
//        返回可以通过分割得到的平衡字符串的最大数量。
//
//         
//
//        示例 1：
//
//        输入：s = "RLRRLLRLRL"
//        输出：4
//        解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//        示例 2：
//
//        输入：s = "RLLLLRRRLR"
//        输出：3
//        解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
//        示例 3：
//
//        输入：s = "LLLLRRRR"
//        输出：1
//        解释：s 只能保持原样 "LLLLRRRR".
//         
//
//        提示：
//
//        1 <= s.length <= 1000
//        s[i] = 'L' 或 'R'

public class P1221 {

    private static class Solution {
        public int balancedStringSplit(String s) {
            int cur = 0;
            int ans = 0;
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == 'R') {
                    cur--;
                } else {
                    cur++;
                }
                if (cur == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
        System.out.println(solution.balancedStringSplit("RLLLLRRRLR"));
        System.out.println(solution.balancedStringSplit("LLLLRRRR"));
    }
}
