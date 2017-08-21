package com.zlq.algorithm.sort;

/**
 * 假设一个数组升序的，从中间某个位置折断，把折断的后端移到开头切逆序，求最大值所在的位置
 * 如原始数据是
 * 1 2 3 4 5 6 7
 * 在5位置折断，则新数组变为
 * 1 2 3 4 7 6 5
 * 求最大值所在的索引位置
 * <p>
 * Created by liqing.zhan on 2017/8/21.
 */
public class ArrayIndex2 {
    public static void main(String[] args) {
        int a[] = {1, 2, 3, 8, 7, 6, 5};
        System.out.println(getMaxValIndex1(a));
        System.out.println(getMaxValIndex(a));
    }


    /**
     * o(ln(n))
     *
     * @param a
     * @return
     */
    public static int getMaxValIndex1(int a[]) {
        int s = 0, e = a.length - 1;
        while (e - s >= 1) {
            int mid = (s + e) / 2;
            if (a[mid] >= a[mid + 1]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }

    /**
     * o(n)
     *
     * @param a
     * @return
     */
    public static int getMaxValIndex(int a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return i;
            }
        }
        throw new RuntimeException("has no one");
    }

}
