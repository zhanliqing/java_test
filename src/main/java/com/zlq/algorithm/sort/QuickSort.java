package com.zlq.algorithm.sort;

import java.util.Random;

/**
 * Created by liqing.zhan on 2017/7/12.
 */
public class QuickSort {
    public static void main(String[] args) {
        int values[] = new int[58];
        HeapSort.initValues(values);
        HeapSort.shuffer(values);
        quicksort(values, 0, values.length - 1);
        HeapSort.print(values);
    }

    private static void quicksort(int[] values, int start, int end) {
        Random random = new Random();
        int idx = random.nextInt(end - start) + start;
        HeapSort.swap(values, start, idx);
        int value = values[start];
        int i = start;
        int j = end;
        while (start < end) {
            while (values[end] >= value && end > start) end--;
            values[start] = values[end];
            while (values[start] <= value && end > start) start++;
            values[end] = values[start];
        }
        values[start] = value;
        if (i < start - 1) {
            quicksort(values, i, start - 1);
        }

        if (start + 1 < j) {
            quicksort(values, start + 1, j);
        }
    }
}
