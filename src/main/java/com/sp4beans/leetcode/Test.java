package com.sp4beans.leetcode;

import java.util.Arrays;

/**
 * @author wangjixin <wangjixin@kuaishou.com>
 * Created on 2020-05-13
 */
public class Test {
    public static void main(String[] args) {
        Arrays.stream(func(new int[] {1, 5, 6, 7,}, new int[] {-4, 6, 23}, new int[] {2, 3, 4, 8, 9}))
                .forEach(i -> System.out.print(i + " "));
    }

    public static int[] func(int[] a, int[] b, int[] c) {
        int lengthA = a.length;
        int lengthB = b.length;
        int lengthC = c.length;
        int indexA = 0;
        int indexB = 0;
        int indexC = 0;
        int[] ans = new int[lengthA + lengthB + lengthC];
        int curIndex = 0;
        while (curIndex < lengthA + lengthB + lengthC) {
            int curQueue = 0;
            int curMin = Integer.MAX_VALUE;
            if (indexA < lengthA) {
                curQueue = 0;
                curMin = a[indexA];
            }

            if (indexB < lengthB && b[indexB] < curMin) {
                curQueue = 1;
                curMin = b[indexB];
            }

            if (indexC < lengthC && c[indexC] < curMin) {
                curQueue = 2;
                curMin = c[indexC];
            }

            ans[curIndex++] = curMin;
            if (curQueue == 0) {
                indexA++;
            } else if (curQueue == 1) {
                indexB++;
            } else {
                indexC++;
            }
        }
        return ans;
    }
}
