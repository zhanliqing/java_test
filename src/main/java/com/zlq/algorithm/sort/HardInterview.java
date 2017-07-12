package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/7/12.
 */
public class HardInterview {
    public static void main(String[] args) {
        test1();
    }

    public static void test2() {
        int a[] = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < a.length; i++) {

        }
    }

    public static void test1() {
        int a = 334343;
        int b = 1278456;

        int count = 0;
        while (b != 0) {
            count++;
            int c = a ^ b;
            int d = a & b;
            d <<= 1;
            b = d;
            a = c;
        }
        System.out.println(a);
        System.out.println(count);
    }
}
