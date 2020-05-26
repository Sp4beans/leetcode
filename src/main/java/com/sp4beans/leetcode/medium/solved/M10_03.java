package com.sp4beans.leetcode.medium.solved;

//        搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
//
//        示例1:
//
//        输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
//        输出: 8（元素5在该数组中的索引）
//        示例2:
//
//        输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
//        输出：-1 （没有找到）
//        提示:
//
//        arr 长度范围在[1, 1000000]之间

public class M10_03 {
    private static class Solution {
        public int search(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                if (arr[start] == target) {
                    return start;
                }
                if (arr[start] == arr[end]) {
                    start++;
                    end--;
                    continue;
                }
                int mid = (start + end) >> 1;
                if (arr[mid] == target) {
                    while (mid > start && arr[mid - 1] == arr[mid]) {
                        mid--;
                    }
                    return mid;
                }
//                System.out.println("start = " + start + ", end = " + end + ", midVal = " + arr[mid]);
                if (arr[start] < arr[end]) {
                    if (arr[mid] > target) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (arr[mid] >= arr[start] && arr[mid] >= arr[end]) {
                        if (arr[mid] > target) {
                            if (arr[start] <= target) {
                                end = mid - 1;
                            } else {
                                start = mid + 1;
                            }
                        } else {
                            start = mid + 1;
                        }
                    } else {
                        if (arr[mid] > target) {
                                end = mid - 1;
                        } else {
                            if (arr[start] <= target) {
                                end = mid - 1;
                            } else {
                                start = mid + 1;
                            }
                        }
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
                System.out.println(solution.search(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5)); // 8
        System.out.println(solution.search(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 11)); // -1
        System.out.println(solution.search(new int[] {1, 1, 1, 1, 1, 2, 1, 1, 1}, 2)); // 5
        System.out.println(solution.search(new int[] {5, 5, 5, 1, 2, 3, 4, 5}, 5)); // 0
        System.out.println(solution.search(
                new int[] {12, 20, -21, -21, -19, -14, -11, -8, -8, -8, -6, -6, -4, -4, 0, 1, 5, 5, 6, 11,
                        11, 12},
                -8)); // 7
        System.out.println(solution.search(new int[] {1, -2}, -2)); // 1
        System.out.println(solution.search(
                new int[] {1, 4, 4, 5, 5, 12, 17, 17, 20, 20, 21, 22, 22, 24, 24, 27, 29, 30, 32, 41, 41,
                        45, 45, 46,
                        47, 49, 53, 57, 57, 63, 63, -63, -63, -62, -56, -52, -48, -47, -44, -43, -43, -42,
                        -41, -39,
                        -39, -37, -34, -33, -32, -32, -29, -26, -25, -23, -16, -13, -11, -8, -7, -7, -6,
                        -4, -2, -2},
                -23)); // 53
        System.out.println(solution.search(
                new int[] {18, 19, 22, 30, 31, 38, 38, 40, 43, 43, 45, 45, 46, 46, 48, 53, 56, 58, 62, 62, 62, 65, 71,
                        75, 77, 78, 81, -81, -75, -74, -74, -72, -70, -69, -69, -67, -60, -59, -56, -55, -54, -52, -52,
                        -51, -51, -44, -41, -41, -39, -38, -34, -32, -32, -31, -31, -27, -26, -24, -24, -23, -22, -20,
                        -18, -18, -18, -17, -16, -14, -11, -9, -8, -6, -5, -3, -1, 4, 10, 11, 11, 15, 16}, 53)); // 15
    }
}
