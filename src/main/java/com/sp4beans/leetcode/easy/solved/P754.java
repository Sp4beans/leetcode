package com.sp4beans.leetcode.easy.solved;

//        在一根无限长的数轴上，你站在0的位置。终点在target的位置。
//
//        每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。
//
//        返回到达终点需要的最小移动次数。
//
//        示例 1:
//
//        输入: target = 3
//        输出: 2
//        解释:
//        第一次移动，从 0 到 1 。
//        第二次移动，从 1 到 3 。
//        示例 2:
//
//        输入: target = 2
//        输出: 3
//        解释:
//        第一次移动，从 0 到 1 。
//        第二次移动，从 1 到 -1 。
//        第三次移动，从 -1 到 2 。
//        注意:
//
//        target是在[-10^9, 10^9]范围中的非零整数。

//        var reachNumber = function(target) {
//        if (target < 0) {
//        target = -target
//        }
//        let n = 0
//        while (target > 0 || target % 2) {
//        n++
//        target -= n
//        }
//        return n
//        };
//
//        作者：382615666
//        链接：https://leetcode-cn.com/problems/two-sum/solution/jsxie-fa-by-382615666-6/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public class P754 {
    private static class Solution {
        public int reachNumber(int target) {
            if (target < 0) {
                target = -target;
            }
            int n = 0;
            while (target > 0 || target % 2 != 0) {
                n++;
                target -= n;
            }
            return n;
        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.reachNumber(-1));
        System.out.println(solution.reachNumber(3));
        System.out.println(solution.reachNumber(2));
        System.out.println(solution.reachNumber(4));
    }
}

