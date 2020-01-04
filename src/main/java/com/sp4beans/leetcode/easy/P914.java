package com.sp4beans.leetcode.easy;

//        给定一副牌，每张牌上都写着一个整数。
//
//        此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
//
//        每组都有 X 张牌。
//        组内所有的牌上都写着相同的整数。
//        仅当你可选的 X >= 2 时返回 true。
//
//         
//
//        示例 1：
//
//        输入：[1,2,3,4,4,3,2,1]
//        输出：true
//        解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
//        示例 2：
//
//        输入：[1,1,1,2,2,2,3,3]
//        输出：false
//        解释：没有满足要求的分组。
//        示例 3：
//
//        输入：[1]
//        输出：false
//        解释：没有满足要求的分组。
//        示例 4：
//
//        输入：[1,1]
//        输出：true
//        解释：可行的分组是 [1,1]
//        示例 5：
//
//        输入：[1,1,2,2,2,2]
//        输出：true
//        解释：可行的分组是 [1,1]，[2,2]，[2,2]
//
//        提示：
//
//        1 <= deck.length <= 10000
//        0 <= deck[i] < 10000

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class P914 {
    private static class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : deck) {
                if (map.containsKey(i)) {
                    map.put(i, map.get(i) + 1);
                } else {
                    map.put(i, 1);
                }
            }

            List<Integer> list = new ArrayList<>(map.values());
            if (list.size() == 1) {
                return list.get(0) > 1;
            } else {
                int ans = 0;
                for (int i = 1; i < list.size(); i++) {
                    if (i == 1) {
                        ans = gcd(list.get(i), list.get(i - 1));
                    } else {
                        ans = gcd(list.get(i), ans);
                    }
                }
                return ans > 1;
            }
        }

        public int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1, 1, 2, 2, 2, 3, 3}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1, 2, 2, 2, 2}));
    }

}
