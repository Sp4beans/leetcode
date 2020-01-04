package com.sp4beans.leetcode.easy;

//	中心对称数是指一个数字在旋转了 180 度之后看起来依旧相同的数字（或者上下颠倒地看）。
//
//	请写一个函数来判断该数字是否是中心对称数，其输入将会以一个字符串的形式来表达数字。
//
//	示例 1:
//
//	输入:  "69"
//	输出: true
//	示例 2:
//
//	输入:  "88"
//	输出: true
//	示例 3:
//
//	输入:  "962"
//	输出: false

public class P246 {

	private static class Solution {

		public boolean isStrobogrammatic(String num) {

			int start = 0;
			int end = num.length() - 1;
			char[] nums = num.toCharArray();
			while (end >= start) {
				if (!isValidNumber(nums[start])) {
					return false;
				}
				if (!isValidNumber(nums[end])) {
					return false;
				}
				if (start == end) {
					return isSameValidNumber(nums[start], nums[end]);
				}

				if (!isSameValidNumber(nums[start], nums[end])) {
					return false;
				} else {
					start++;
					end--;
				}
			}

			return true;
		}

		private boolean isValidNumber(char c) {
			return c == '0' || c == '1' || c == '6' || c == '8' || c == '9';
		}

		private boolean isSameValidNumber(char a, char b) {
			return (a == '1' && b == '1') || (a == '0' && b == '0') || (a == '8' && b == '8')
				|| (a == '6' && b == '9') || (a == '9' && b == '6');
		}
	}

	public static void main(String args[]) {
		Solution solution = new Solution();
		System.out.println(solution.isSameValidNumber('1', '0'));
		System.out.println(solution.isStrobogrammatic("10"));
		System.out.println(solution.isStrobogrammatic("69"));
		System.out.println(solution.isStrobogrammatic("88"));
		System.out.println(solution.isStrobogrammatic("962"));
	}

}
