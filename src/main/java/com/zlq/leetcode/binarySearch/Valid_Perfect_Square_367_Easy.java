package com.zlq.leetcode.binarySearch;

/**
 * Created by zhanliqing on 2017/8/19.
 */
public class Valid_Perfect_Square_367_Easy {
    public static void main(String[] args) {

//        System.out.println(Solution.isPerfectSquare(1179649));
//        System.out.println(Solution.isPerfectSquare1(1179649));
        System.out.println(Solution.isPerfectSquare1(681));
//        for (int i = 1; i < Integer.MAX_VALUE; i++) {
//            if (Solution.isPerfectSquare(i)) {
//                System.out.println(String.format("%d*%d is %f", i, i, Math.sqrt(i)));
//            }
//        }
    }

    static class Solution {
        public static boolean isPerfectSquare1(int num) {
            int s = 1;
            int e = num;
            while (s < e) {
                int mid = s + ((e - s) >>> 1);
                if (num / mid > mid) {
                    s = mid + 1;
                } else if (num / mid < mid) {
                    e = mid - 1;
                } else {
                    e = mid;
                }
            }
            return s * s == num;
        }

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
            return s * s == num;
        }
    }
}
