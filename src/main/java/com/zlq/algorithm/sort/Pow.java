package com.zlq.algorithm.sort;

/**
 * Created by zhanliqing on 2017/8/1.
 */
public class Pow {
    public static void main(String[] args) {
        System.out.println(pow(3, 9));
        System.out.println(Math.pow(3, 9));
    }

    public static int pow(int x, int n) {
        int result = 1;
        while (n > 0) {
            if ((n & 1L) == 1) {
                result *= x;
            }
            n >>= 1;
            x = x * x;
        }
        return result;
    }
}
