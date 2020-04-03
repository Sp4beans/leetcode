package com.sp4beans.leetcode.easy.solved;

//        从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
//
//         
//
//        示例 1:
//
//        输入: [1,2,3,4,5]
//        输出: True
//         
//
//        示例 2:
//
//        输入: [0,0,1,2,5]
//        输出: True
//         
//
//        限制：
//
//        数组长度为 5 
//
//        数组的数取值为 [0, 13] .

import java.util.HashSet;
import java.util.Set;

public class P61 {
    private class Solution {
        public boolean isStraight(int[] nums) {
            Set<Integer> contains = new HashSet<>();
            int min = 50;
            int countAny = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    countAny ++;
                } else {
                    min = Math.min(min, nums[i]);
                    contains.add(nums[i]);
                }
            }

            for (int i = 0; i < 5; i++) {
                if (!contains.contains(min + i)) {
                    countAny--;
                }
                if (countAny < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
