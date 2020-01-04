package com.sp4beans.leetcode.easy;

//        给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。
//
//        注意:
//
//        给定的整数保证在32位带符号整数的范围内。
//        你可以假定二进制数不包含前导零位。
//        示例 1:
//
//        输入:5
//        输出:2
//        解释:5的二进制表示为101（没有前导零位），其补数为010。所以你需要输出2。
//        示例 2:
//
//        输入:1
//        输出:0
//        解释:1的二进制表示为1（没有前导零位），其补数为0。所以你需要输出0。


public class P476 {

    private static class Solution {

        public int findComplement(int num) {
            int res = 0;
            int c = 0;
            while (num > 0) {
                int p = num & 1;
                if (p == 0) {
                    res += 1 << c;
                }
                c++;
                num >>= 1;
            }
            return res;
        }

//        public int findComplement(int num) {
//            if (num == 0) {
//                return 0;
//            }
//            int tmp = num % 2;
//            num /= 2;
//            return tmp == 1 ? findComplement(num) * 2 : findComplement(num) * 2 + 1;
//        }
    }

    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(4));
        System.out.println(solution.findComplement(1));
    }
}
