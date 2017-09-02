package com.zlq.leetcode.BitManipulation;

/**
 * Created by liqing.zhan on 2017/8/22.
 */
public class Single_Number_136_easy {
    public static void main(String[] args) {

    }

    static class Solution {
        public static int singleNumber(int[] nums) {
            int a = 0;
            for (int i = 0; i < nums.length; i++) {
                a ^= nums[i];
            }
            return a;
        }
    }
}
