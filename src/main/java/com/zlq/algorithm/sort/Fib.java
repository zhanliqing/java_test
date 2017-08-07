package com.zlq.algorithm.sort;

/**
 * Created by zhanliqing on 2017/8/7.
 */
public class Fib {
    public static void main(String[] args) {
        int n = 13;
        int a = 1, b = 1;

        while (n > 1) {
            int c = b;
            b = a;
            a += c;
            n--;
        }

        System.out.println(a);
        System.out.println(fib(13));
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
