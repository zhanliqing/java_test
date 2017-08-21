package com.zlq.algorithm.sort;

/**
 * 二分查找
 * <p>
 * Created by liqing.zhan on 2017/8/21.
 */
public class ArrayBinarySearch {
    public static void main(String[] args) {
        int array[] = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(Solution.binarySearch(array, 9));
    }

    static class Solution {
        public static int binarySearch(int array[], int key) {
            if (array.length <= 0) {
                return -1;
            }

            int low = 0;
            int high = array.length - 1;
            while (low <= high) {
                int mid = (high + low) / 2;
                if (array[mid] < key) {
                    low = mid + 1;
                } else if (array[mid] > key) {
                    high = mid - 1;
                } else {
                    return mid;
                }
            }
            return -1;
        }
    }
}
