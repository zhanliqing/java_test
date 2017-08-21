package com.zlq.leetcode;

import javax.validation.constraints.Max;

import static com.sun.tools.doclint.Entity.sum;

/**
 * Created by zhanliqing on 2017/8/19.
 */
public class Valid_Perfect_Square_367_Easy {
    public static void main(String[] args) {
        System.out.println(Solution.isPerfectSquare(16));
    }

    static class Solution {
        public static boolean isPerfectSquare(int num) {
            int s = 0;
            int e = num;
            int mid = 0;
            while (s < e) {
                mid = (s + e) / 2;
                if (mid * mid > num) {
                    e = mid - 1;
                }
                if (mid * mid < num) {
                    s = mid + 1;
                }
                if (mid * mid == num) {
                    return true;
                }
            }
        }
    }
}
