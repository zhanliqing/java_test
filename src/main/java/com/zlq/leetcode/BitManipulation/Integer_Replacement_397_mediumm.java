package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Integer_Replacement_397_mediumm {
    public static void main(String[] args) {
        System.out.println(Solution.integerReplacement(2147483647));
    }

    static class Solution {
        public static int integerReplacement(int n) {
            if (n <= 0) {
                throw new RuntimeException("dd");
            }
            if (n == 1) {
                return 0;
            }
            if ((n & 1) == 1) {
                return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1));
            } else {
                n >>= 1;
                return 1 + integerReplacement(n);
            }
        }
    }
}
