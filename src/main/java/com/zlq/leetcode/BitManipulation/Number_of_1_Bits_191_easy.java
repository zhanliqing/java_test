package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Number_of_1_Bits_191_easy {
    public static void main(String[] args) {
        System.out.println(Solution.hammingWeight(1));
    }

    static class Solution {
        // you need to treat n as an unsigned value
        public static int hammingWeight(int n) {
            int k = 0;
            while (n != 0) {
                k++;
                n = n & (n - 1);
            }
            return k;
        }
    }
}
