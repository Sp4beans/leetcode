package com.sp4beans.leetcode.easy;

//        公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
//
//        返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
//
//         
//
//        示例：
//
//        输入：[[10,20],[30,200],[400,50],[30,20]]
//        输出：110
//        解释：
//        第一个人去 A 市，费用为 10。
//        第二个人去 A 市，费用为 30。
//        第三个人去 B 市，费用为 50。
//        第四个人去 B 市，费用为 20。
//
//        最低总费用为 10 + 30 + 50 + 20 = 110，每个城市都有一半的人在面试。
//         
//
//        提示：
//
//        1 <= costs.length <= 100
//        costs.length 为偶数
//        1 <= costs[i][0], costs[i][1] <= 1000

import java.util.Arrays;

public class P1029 {
    private static class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int[] dif = new int[costs.length];
            int result = 0;
            for (int i = 0; i < costs.length; i++) {
                result += costs[i][1];
                dif[i] = costs[i][0] - costs[i][1];
            }
            Arrays.sort(dif);
            for (int i = 0; i < costs.length / 2; i++) {
                result += dif[i];
            }
            return result;
        }

//        public int twoCitySchedCost(int[][] costs) {
//            Arrays.sort(costs, (a, b) -> {
//                return Integer.compare(a[0] - a[1], b[0] - b[1]);
//            });
//            int ans = 0;
//            for (int i = 0; i < costs.length; i++) {
//                if (i < costs.length / 2) {
//                    ans += costs[i][0];
//                } else {
//                    ans += costs[i][1];
//                }
//            }
//            return ans;
//        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }
}
