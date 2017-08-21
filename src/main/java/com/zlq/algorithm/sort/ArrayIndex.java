package com.zlq.algorithm.sort;

/**
 * 假设一个数组升序的，从中间某个位置折断，把折断的后端移到开头，求最大值所在的位置
 * 如原始数据是
 * 1 2 3 4 5 6 7
 * 在5位置折断，则新数组变为
 * 5 6 7 1 2 3 4
 * 求最大值所在的索引位置
 * <p>
 * Created by liqing.zhan on 2017/8/18.
 */
public class ArrayIndex {
    public static void main(String[] args) {
        int a[] = {5, 6, 7, 8, 1, 2, 3, 4};
        System.out.println(getMaxValIndex2(a));
        System.out.println(getMaxValIndex1(a));
        System.out.println(getMaxValIndex(a));
    }


    public static int getMaxValIndex2(int a[]) {
        int s = 0, e = a.length - 1;
        while (s <= e) {
            int mid = (s + e) / 2;
            if (a[mid] < a[s]) {
                e = mid - 1;
            } else if (a[mid] > a[s]) {
                s = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    /**
     * o(ln(n))
     *
     * @param a
     * @return
     */
    public static int getMaxValIndex1(int a[]) {
        int s = 0, e = a.length - 1;
        while (s < e) {
            int mid = (s + e + 1) / 2;
            if (a[mid] < a[s]) {
                e = mid - 1;
            } else {
                s = mid;
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
