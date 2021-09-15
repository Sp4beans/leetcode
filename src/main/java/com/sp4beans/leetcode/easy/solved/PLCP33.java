package com.sp4beans.leetcode.easy.solved;

//        给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 i 个水缸配备的水桶容量记作 bucket[i]。小扣有以下两种操作：
//
//        升级水桶：选择任意一个水桶，使其容量增加为 bucket[i]+1
//        蓄水：将全部水桶接满水，倒入各自对应的水缸
//        每个水缸对应最低蓄水量记作 vat[i]，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
//
//        注意：实际蓄水量 达到或超过 最低蓄水量，即完成蓄水要求。
//
//        示例 1：
//
//        输入：bucket = [1,3], vat = [6,8]
//
//        输出：4
//
//        解释：
//        第 1 次操作升级 bucket[0]；
//        第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
//
//
//        示例 2：
//
//        输入：bucket = [9,0,1], vat = [0,2,2]
//
//        输出：3
//
//        解释：
//        第 1 次操作均选择升级 bucket[1]
//        第 2~3 次操作选择蓄水，即可完成蓄水要求。
//
//        提示：
//
//        1 <= bucket.length == vat.length <= 100
//        0 <= bucket[i], vat[i] <= 10^4

public class PLCP33 {
    private class Solution {
        public int storeWater(int[] bucket, int[] vat) {
            int result = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] == 0 && vat[i] != 0) {
                    bucket[i]++;
                    result++;
                }
            }
            int max = 0;
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] == 0) {
                    continue;
                }
                int times = calc(vat[i], bucket[i]);
                max = Math.max(max, times);
            }

            int minAns = 0;
            for (int time = 1; time <= max && time > 0; time++) {
                int tmp = 0;
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i] == 0) {
                        continue;
                    }
                    int target = calc(vat[i], time);
                    if (target > bucket[i]) {
                        tmp += target - bucket[i];
                    }
                }
                tmp += time;
                if (minAns == 0) {
                    minAns = tmp;
                } else {
                    minAns = Math.min(minAns, tmp);
                }
            }

            return minAns + result;
        }

        private int calc(int a, int b) {
            if (a % b == 0) {
                return a / b;
            } else {
                return a / b + 1;
            }
        }
    }
}
