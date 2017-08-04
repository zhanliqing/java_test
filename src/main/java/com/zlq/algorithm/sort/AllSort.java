package com.zlq.algorithm.sort;

/**
 * 输出数组的全排序
 * Created by liqing.zhan on 2017/7/12.
 */
public class AllSort {
    public static void main(String[] args) {
        int array[] = {1, 2, 3,4};
        all(0, array.length, array);
    }

    public static void all(int start, int stop, int array[]) {
        if (start >= stop - 1) {
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < stop; i++) {
                swap(start, i, array);
                all(start + 1, stop, array);
                swap(start, i, array);
            }
        }
    }

    public static void swap(int i, int j, int array[]) {
        int c = array[i];
        array[i] = array[j];
        array[j] = c;
    }

}
