package com.zlq.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqing.zhan on 2017/7/13.
 */
public class AllSubSet {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
        List<int[]> sets = new ArrayList<>();
        getSubSet(a, 7, sets);

        for (int[] t : sets) {
            for (int i = 0; i < t.length; i++) {
                System.out.print(t[i] + " ");
            }
            System.out.println();
        }
    }

    public static void getSubSet(int values[], int end, List<int[]> subSets) {
        if (end == -1) {
            subSets.add(new int[]{});
        } else {
            getSubSet(values, end - 1, subSets);
            int size = subSets.size();
            for (int i = 0; i < size; i++) {
                int[] t = subSets.get(i);
                int t1[] = new int[t.length + 1];
                System.arraycopy(t, 0, t1, 0, t.length);
                t1[t.length] = values[end];
                subSets.add(t1);
            }
        }
    }
}
