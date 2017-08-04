package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/8/1.
 */
public class Npow {
    public static void main(String[] args) {
        System.out.println(pow(2, 21));
        System.out.println(pow1(2, 21));
        System.out.println(pow2(2, 21));
        System.out.println(5 / 2);
    }

    public static int pow2(int x, int n) {
        int m = n;
        int result = 1;
        while (m > 0) {
            if (m % 2 != 0) {
                result = result * x;
            }
            x *= x;
            m = m / 2;
        }
        return result;
    }

    public static int pow1(int x, int n) {
        if (n == 1) {
            return x;
        }
        int tmp = pow1(x, n / 2);
        if (n % 2 == 0) {
            return tmp * tmp;
        } else {
            return tmp * tmp * x;
        }
    }

    public static int pow(int x, int n) {
        int tmp = 1;
        while (n-- > 0) {
            tmp *= x;
        }
        return tmp;
    }
}
