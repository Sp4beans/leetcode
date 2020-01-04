package com.sp4beans.leetcode.easy;

//	给定一个数字 N，当它满足以下条件的时候返回 true：
//
//	原数字旋转 180° 以后可以得到新的数字。
//
//	如 0, 1, 6, 8, 9 旋转 180° 以后，得到了新的数字 0, 1, 9, 8, 6 。
//
//	2, 3, 4, 5, 7 旋转 180° 后，得到的不是数字。
//
//	易混淆数 (confusing number) 在旋转180°以后，可以得到和原来不同的数，且新数字的每一位都是有效的。
//
//	 
//
//	示例 1：
//
//
//
//	输入：6
//	输出：true
//	解释：
//	把 6 旋转 180° 以后得到 9，9 是有效数字且 9!=6 。
//	示例 2：
//
//
//
//	输入：89
//	输出：true
//	解释:
//	把 89 旋转 180° 以后得到 68，86 是有效数字且 86!=89 。
//	示例 3：
//
//
//
//	输入：11
//	输出：false
//	解释：
//	把 11 旋转 180° 以后得到 11，11 是有效数字但是值保持不变，所以 11 不是易混淆数字。
//	示例 4：
//
//
//
//	输入：25
//	输出：false
//	解释：
//	把 25 旋转 180° 以后得到的不是数字。
//	 
//
//	提示：
//
//	0 <= N <= 10^9
//	可以忽略掉旋转后得到的前导零，例如，如果我们旋转后得到 0008 那么该数字就是 8 。

public class P1056 {

	private static class Solution {

		public boolean confusingNumber(int N) {
			char[] val = String.valueOf(N).toCharArray();
			long newVal = 0;
			int start = 0;
			int end = val.length - 1;
			for (int i = end; i >= 0; i--) {
				if (!isValidNumber(val[i])) {
					return false;
				}
				newVal = newVal * 10 + (getNextNumber(val[i]) - '0');
			}
			return newVal != N;
		}

		private boolean isValidNumber(char c) {
			return c == '0' || c == '1' || c == '6' || c == '8' || c == '9';
		}

		private char getNextNumber(char a) {
			if (a == '0' || a == '1' || a == '8') {
				return a;
			} else if (a == '6') {
				return '9';
			} else if (a == '9') {
				return '6';
			}
			return ' ';
		}
	}

	public static void main(String args[]) {
		Solution solution = new Solution();
		System.out.println(solution.confusingNumber(6));
		System.out.println(solution.confusingNumber(11));
		System.out.println(solution.confusingNumber(89));
		System.out.println(solution.confusingNumber(25));
	}
}
