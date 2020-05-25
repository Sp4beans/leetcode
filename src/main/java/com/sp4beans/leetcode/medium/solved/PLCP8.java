package com.sp4beans.leetcode.medium.solved;

import java.util.Arrays;

//        在战略游戏中，玩家往往需要发展自己的势力来触发各种新的剧情。一个势力的主要属性有三种，分别是文明等级（C），资源储备（R）以及人口数量（H）。在游戏开始时（第 0 天），三种属性的值均为 0。
//
//        随着游戏进程的进行，每一天玩家的三种属性都会对应增加，我们用一个二维数组 increase 来表示每天的增加情况。这个二维数组的每个元素是一个长度为 3 的一维数组，例如 [[1,2,1],[3,4,2]] 表示第一天三种属性分别增加 1,2,1 而第二天分别增加 3,4,2。
//
//        所有剧情的触发条件也用一个二维数组 requirements 表示。这个二维数组的每个元素是一个长度为 3 的一维数组，对于某个剧情的触发条件 c[i], r[i], h[i]，如果当前 C >= c[i] 且 R >= r[i] 且 H >= h[i] ，则剧情会被触发。
//
//        根据所给信息，请计算每个剧情的触发时间，并以一个数组返回。如果某个剧情不会被触发，则该剧情对应的触发时间为 -1 。
//
//        示例 1：
//
//        输入： increase = [[2,8,4],[2,5,0],[10,9,8]] requirements = [[2,11,3],[15,10,7],[9,17,12],[8,1,14]]
//
//        输出: [2,-1,3,-1]
//
//        解释：
//
//        初始时，C = 0，R = 0，H = 0
//
//        第 1 天，C = 2，R = 8，H = 4
//
//        第 2 天，C = 4，R = 13，H = 4，此时触发剧情 0
//
//        第 3 天，C = 14，R = 22，H = 12，此时触发剧情 2
//
//        剧情 1 和 3 无法触发。
//
//        示例 2：
//
//        输入： increase = [[0,4,5],[4,8,8],[8,6,1],[10,10,0]] requirements = [[12,11,16],[20,2,6],[9,2,6],[10,18,3],[8,14,9]]
//
//        输出: [-1,4,3,3,3]
//
//        示例 3：
//
//        输入： increase = [[1,1,1]] requirements = [[0,0,0]]
//
//        输出: [0]
//
//        限制：
//
//        1 <= increase.length <= 10000
//        1 <= requirements.length <= 100000
//        0 <= increase[i] <= 10
//        0 <= requirements[i] <= 100000
public class PLCP8 {
    private class Solution {
        public int[] getTriggerTime(int[][] increase, int[][] requirements) {
            int[] c = new int[100001];
            int[] r = new int[100001];
            int[] h = new int[100001];
            Arrays.fill(c, -1);
            Arrays.fill(r, -1);
            Arrays.fill(h, -1);
            int startc = 1;
            int startr = 1;
            int starth = 1;
            int[] cur = new int[]{0,0,0};
            int index = 0;
            c[0] = 0;
            r[0] = 0;
            h[0] = 0;
            for(int[] inc : increase) {
                index++;
                cur[0] += inc[0];
                cur[1] += inc[1];
                cur[2] += inc[2];
                if (startc <= cur[0] && cur[0] < 100000) {
                    Arrays.fill(c, startc, cur[0] + 1, index);
                }
                if (startr <= cur[1] && cur[1] < 100000) {
                    Arrays.fill(r, startr, cur[1] + 1, index);
                }
                if (starth <= cur[2] && cur[2] < 100000) {
                    Arrays.fill(h, starth, cur[2] + 1, index);
                }
                startc = cur[0] + 1;
                startr = cur[1] + 1;
                starth = cur[2] + 1;
            }

            int[] res = new int[requirements.length];
            for (int i = 0; i < requirements.length; i++) {
                int[] req = requirements[i];
                int cc = c[req[0]];
                int rr = r[req[1]];
                int hh = h[req[2]];
                if (cc == -1 || rr == -1 || hh == -1) {
                    res[i] = -1;
                } else {
                    res[i] = Math.max(hh, Math.max(cc, rr));
                }
            }
            return res;
        }
    }
}