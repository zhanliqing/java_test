package com.zlq.leetcode;

import java.util.Arrays;

/**
 * Created by zhanliqing on 2017/8/19.
 */
public class Array_Partition_I_Easy {
    public static void main(String[] args) {

    }

    static class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int sum = 0;
            for (int i = 0; i < nums.length; i += 2) {
                sum += nums[i];
            }
            return sum;
        }
    }
}
