package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Power_of_Two_231_easy {
    public static void main(String[] args) {

    }

    static class Solution {
        public static boolean isPowerOfTwo(int n) {
            if (n == 1) {
                return true;
            }
            if (n <= 0) {
                return false;
            }
            return (n & (n - 1)) == 0;
        }
    }
}
