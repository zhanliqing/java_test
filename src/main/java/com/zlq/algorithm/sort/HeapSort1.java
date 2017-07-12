package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/7/12.
 */
public class HeapSort1 {
    public static void main(String[] args) {
        int values[] = new int[30];
        HeapSort.initValues(values);
        HeapSort.shuffer(values);
        HeapSort.print(values);
        makeHeap(values);
        HeapSort.print(values);
        heapsort(values);
        HeapSort.print(values);
    }


    private static void heapsort(int[] values) {
        int length = values.length - 1;
        for (int i = 0; i < values.length; i++) {
            HeapSort.swap(values, 0, length - i);
            adjust(values, 0, length - i - 1);
        }
    }

    private static void makeHeap(int[] values) {
        int middle = values.length / 2;
        for (int i = middle; i >= 0; i--) {
            adjust(values, i, values.length - 1);
        }
    }

    private static void adjust(int[] values, int i, int end) {
        while (left(i) <= end || right(i) <= end) {
            int j = i;
            int max = values[i];
            if (max < values[left(i)]) {
                j = left(i);
                max = values[left(i)];
            }
            if (right(i) <= end) {
                if (max < values[right(i)]) {
                    j = right(i);
                }
            }

            if (i != j) {
                HeapSort.swap(values, i, j);
            } else {
                return;
            }
            i = j;
        }
    }

    private static int left(int n) {
        return 2 * n + 1;
    }

    public static int right(int n) {
        return 2 * (n + 1);
    }
}
