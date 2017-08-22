package com.zlq.leetcode.binarySearch;

/**
 * Created by liqing.zhan on 2017/8/21.
 */
public class Valid_Perfect_Square_367_easy {
    public static void main(String[] args) {
        int value = 5;
        System.out.println(Solution.isPerfectSquare(value));
        System.out.println(Solution.isPerfectSquare1(value));

    }

    static class Solution {
        public static boolean isPerfectSquare1(int num) {
            int s = 1;
            int e = num;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                System.out.println(num / mid);
                if (num / mid < mid) {
                    e = mid - 1;
                } else if (num / mid > mid) {
                    s = mid + 1;
                } else {
                    return true;
                }
            }
            return false;
        }

        public static boolean isPerfectSquare(int num) {
            int s = 0;
            int e = num;
            while (s <= e) {
                int mid = (s + e) >>> 1;
                if (mid == 0) {
                    s = mid + 1;
                } else {
                    if ((double) num / mid < mid) {
                        e = mid - 1;
                    } else if ((double) num / mid > mid) {
                        s = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
