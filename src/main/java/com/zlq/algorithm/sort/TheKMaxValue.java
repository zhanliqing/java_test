package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/8/21.
 */
public class TheKMaxValue {
    public static void main(String[] args) {
        int values[] = new int[]{3, 5, 2, 7, 55, 20, 19, 33, 45, 83, 48};
//        HeapSort.initValues(values);
//        HeapSort.shuffer(values);
        HeapSort.print(values);
        System.out.println(Solution.getTheKMaxIndex(values, values.length / 2));
        HeapSort.print(values);
    }

    static class Solution {
        public static int getTheKMaxIndex(int array[], int k) {
            return getTheKMaxIndex(array, 0, array.length - 1, k);
        }

        private static int getTheKMaxIndex(int array[], int s, int e, int k) {
            int s1 = s;
            int e1 = e;
            int v = array[s1];
            int k1 = 0;
            while (s1 < e1) {
                while (array[e1] > v && e1 > s1) e1--;
                if (e1 > s1) {
                    HeapSort.swap(array, s1++, e1);
                    k1++;
                }
                while (array[s1] < v && e1 > s1) {
                    s1++;
                    k1++;
                }

                if (e1 > s1) {
                    HeapSort.swap(array, s1, e1--);
                }
            }

            if (k1 > k) {
                return getTheKMaxIndex(array, s, s + k1 - 1, k);
            } else if (k1 < k) {
                return getTheKMaxIndex(array, s + k1 + 1, e, k - k1 - 1);
            }
            return array[k1 + s - 1];
        }
    }
}
