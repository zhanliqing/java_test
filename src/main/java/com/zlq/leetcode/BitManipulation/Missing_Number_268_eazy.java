package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Missing_Number_268_eazy {
    public static void main(String[] args) {

    }

    static class Solution {
        public static int missingNumber(int[] nums) {
            int res = nums.length;
            for (int i = 0; i < nums.length; i++) {
                res ^= i;
                res ^= nums[i];
            }
            return res;
        }
    }
}
