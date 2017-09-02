package com.zlq.leetcode.binarySearch;

/**
 * Created by zhanliqing on 2017/8/21.
 */
public class Arranging_Coins_441_easy {
    public static void main(String[] args) {
        System.out.println(Solution.arrangeCoins1(5));
        System.out.println(Solution.arrangeCoins2(5));
        System.out.println(Solution.arrangeCoins3(5));
    }

    static class Solution {
        public static int arrangeCoins3(int n) {
            int s = 0;
            int e = n;
            while (s <= e) {
                int mid = (s + e) >>> 1;
                if ((0.5 * mid * mid + 0.5 * mid) < n) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            return s - 1;
        }


        public static int arrangeCoins2(int n) {
            return (int) (Math.sqrt(2 * n - 0.25) - 0.5);
        }

        public static int arrangeCoins1(int n) {
            return (int) ((Math.sqrt(1 + 8.0 * n) - 1) / 2);
        }

        public static int arrangeCoins(int n) {
            int i = 0;
            while (i * (i + 1) / 2 <= n) {
                i++;
            }
            return i - 1;
        }
    }
}
