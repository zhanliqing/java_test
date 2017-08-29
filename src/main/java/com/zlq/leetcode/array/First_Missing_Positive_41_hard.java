package com.zlq.leetcode.array;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p>
 * Created by liqing.zhan on 2017/8/28.
 */
public class First_Missing_Positive_41_hard {
    public static void main(String[] args) {
        int a[] = {1, 2, 0};
        int b[] = {3, 4, -1, 1};
        System.out.println(Solution.firstMissingPositive(a));
        System.out.println(Solution.firstMissingPositive(b));

    }

    static class Solution {
        public static int firstMissingPositive1(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= 0) {
                    min = Math.min(min, nums[i]);
                } else {
                    nums[i] = 0;
                }
            }

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= min) {
                    nums[]
                }
            }
        }

        /**
         * O(n) space
         *
         * @param nums
         * @return
         */
        public static int firstMissingPositive(int[] nums) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    min = Math.min(min, nums[i]);
                }
            }

            boolean tmp[] = new boolean[nums.length + min];
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    tmp[nums[i] - min] = true;
                }
            }

            for (int i = 0; i < tmp.length; i++) {
                if (tmp[i] == false) {
                    return min + i;
                }
            }
            return min + tmp.length;
        }
    }
}
