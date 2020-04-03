package com.sp4beans.leetcode.easy.solved;

//        给你两个数组，arr1 和 arr2，
//
//        arr2 中的元素各不相同
//        arr2 中的每个元素都出现在 arr1 中
//        对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//
//         
//
//        示例：
//
//        输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//        输出：[2,2,2,1,4,3,3,9,6,7,19]
//         
//
//        提示：
//
//        arr1.length, arr2.length <= 1000
//        0 <= arr1[i], arr2[i] <= 1000
//        arr2 中的元素 arr2[i] 各不相同
//        arr2 中的每个元素 arr2[i] 都出现在 arr1 中

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class P1122 {
    private class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < arr2.length; i++) {
                map.put(arr2[i], i);
            }
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < arr1.length; i++) {
                list.add(arr1[i]);
            }
            Collections.sort(list, (a, b) -> {
                if (map.containsKey(a) && map.containsKey(b)) {
                    return Integer.compare(map.get(a), map.get(b));
                } else if (map.containsKey(a) && !map.containsKey(b)) {
                    return -1;
                } else if (!map.containsKey(a) && map.containsKey(b)) {
                    return 1;
                } else {
                    return Integer.compare(a, b);
                }
            });
            for (int i = 0; i < list.size(); i++) {
                arr1[i] = list.get(i);
            }
            return arr1;
        }
    }
}
