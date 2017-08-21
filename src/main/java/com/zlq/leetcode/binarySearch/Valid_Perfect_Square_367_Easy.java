package com.zlq.leetcode.binarySearch;

/**
 * Created by zhanliqing on 2017/8/19.
 */
public class Valid_Perfect_Square_367_Easy {
    public static void main(String[] args) {
        System.out.println(Solution.isPerfectSquare(25));
    }

    static class Solution {
        public static boolean isPerfectSquare(int num) {
            int s = 1;
            int e = num;
            while (s < e) {
                int mid = (s + e) / 2;
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
            return false;
        }
    }
}
