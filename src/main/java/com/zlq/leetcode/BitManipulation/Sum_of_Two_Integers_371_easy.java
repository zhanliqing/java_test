package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Sum_of_Two_Integers_371_easy {
    public static void main(String[] args) {

    }

    static class Solution {
        public static int getSum(int a, int b) {
            int c = a;
            int d = b;
            int e = c;
            while (d != 0) {
                c = c ^ d;
                d = (e & d) << 1;
                e = c;
            }
            return c;
        }
    }
}
