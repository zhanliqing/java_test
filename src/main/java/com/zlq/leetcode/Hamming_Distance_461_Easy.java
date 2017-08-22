package com.zlq.leetcode;

/**
 * Created by zhanliqing on 2017/8/19.
 */
public class Hamming_Distance_461_Easy {
    public static void main(String[] args) {
        int x = 10;
        int y = 12308493;
        System.out.println(Solution.hammingDistance(x, y));
    }

    static class Solution {
        public static int hammingDistance(int x, int y) {
            int c = x ^ y;
            int t = 0;
            while (c != 0) {
                c = c & (c - 1);
                t++;
            }
            return t;
        }
    }
}
