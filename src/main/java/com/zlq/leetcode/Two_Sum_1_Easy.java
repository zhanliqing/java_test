package com.zlq.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhanliqing on 2017/8/16.
 */
public class Two_Sum_1_Easy {
    public static void main(String[] args) {
        int num[] = {2, 7, 11, 5, 15, 20};
//        int n[] = twoSum1(num, 9);
//        int n[] = twoSum2(num, 9);
        int n[] = twoSum3(num, 12);
        for (int i = 0; i < n.length; i++) {
            System.out.print(String.format("%d\t", n[i]));
        }
    }

    /**
     * 任意两个遍历
     *
     * @param nums
     * @param target
     * @return
     */

    public static int[] twoSum3(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new RuntimeException("has no one");
    }

    /**
     * 如果nums里是按从小到大排序
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;

        while (s < e) {
            if (nums[s] + nums[e] == target) {
                return new int[]{s, e};
            } else if (nums[s] + nums[e] > target) {
                e--;
            } else if (nums[s] + nums[e] < target) {
                s++;
            }
        }
        throw new RuntimeException("has no one");
    }


    /**
     * 通过map
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
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

        throw new RuntimeException("has no one");
    }
}
