package com.zlq.algorithm.sort;

import java.util.Random;

/**
 * Created by liqing.zhan on 2017/7/10.
 */
public class MiddleHardInterview {
    public static void main(String[] args) {
//        t1();
        t4();
    }

    static void t17() {
        Random random = new Random();

    }

    static void t4() {
        int a = 3;
        int b = 4;
        System.out.println((b - a) >> 31 & 1);
    }

    static void t1() {
        int a = 3;
        int b = 4;
        System.out.println("a=" + a + " b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("a=" + a + " b=" + b);

        a = 3;
        b = 4;
        a = a - b;
        b = a + b;
        a = b - a;
        System.out.println("a=" + a + " b=" + b);

        a = 3;
        b = 4;
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("a=" + a + " b=" + b);
    }
}
