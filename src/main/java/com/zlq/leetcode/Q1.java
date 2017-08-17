package com.zlq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanliqing on 2017/8/16.
 */
public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> vk = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int m = target - value;
            if (vk.get(m) != null) {
                return new int[]{vk.get(m), i};
            } else {
                vk.put(value, i);
            }
        }
        return new int[]{0, 0};
    }
}
