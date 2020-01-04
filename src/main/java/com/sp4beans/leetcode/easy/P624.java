package com.sp4beans.leetcode.easy;

//	给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离
//
//	示例 1：
//
//	输入：
//	[[1,2,3],
//	[4,5],
//	[1,2,3]]
//	输出： 4
//	解释：
//	一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
//	 
//
//	注意：
//
//	每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。
//	所有 m 个数组中的数字总数目在范围 [2, 10000] 内。
//	m 个数组中所有整数的范围在 [-10000, 10000] 内。

import java.util.Arrays;
import java.util.List;

public class P624 {

	private static class Solution {

		public int maxDistance(List<List<Integer>> arrays) {
			int[] min = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};
			int[] max = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

			List<Integer> a1 = arrays.get(0);
			List<Integer> a2 = arrays.get(1);

			min[0] = a1.get(0) < a2.get(0) ? a1.get(0) : a2.get(0);
			min[1] = a1.get(0) < a2.get(0) ? a2.get(a2.size() - 1) : a1.get(a1.size() - 1);

			max[1] = a1.get(a1.size() - 1) > a2.get(a2.size() - 1) ? a1.get(a1.size() - 1)
				: a2.get(a2.size() - 1);
			max[0] = a1.get(a1.size() - 1) > a2.get(a2.size() - 1) ? a2.get(0) : a1.get(0);

			for (int i = 2; i < arrays.size(); i++) {
				List<Integer> array = arrays.get(i);
				int minVal = array.get(0);
				int maxVal = array.get(array.size() - 1);

				if (minVal < min[0]) {
					min[0] = minVal;
				} else if (maxVal > min[1]) {
					min[1] = maxVal;
				}

				if (maxVal > max[1]) {
					max[1] = maxVal;
				} else if (minVal < max[0]) {
					max[0] = minVal;
				}
			}

			return Integer.max(min[1] - min[0], max[1] - max[0]);
		}
	}

	public static void main(String args[]) {
		Solution solution = new Solution();
		System.out
			.println(solution.maxDistance(Arrays.asList(Arrays.asList(1, 4), Arrays.asList(0, 5))));
	}
}
