package com.zlq.algorithm.sort;

import java.util.Random;

/**
 * Created by liqing.zhan on 2017/7/3.
 */
public class Random_t1 {
    public static void main(String[] args) {
        Random random = new Random();

        int count = 100000000;

        int sum = 0;
        int big = 0;
        int small = 0;
        int equ = 0;
        while (count-- > 0) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int c = random.nextInt(100);

            if (Math.abs(a - b) == Math.abs(a - c)) {
                equ++;
            }

            if (Math.abs(a - b) > Math.abs(a - c)) {
                big++;
            }

            if (Math.abs(a - b) < Math.abs(a - c)) {
                small++;
            }
            sum++;
        }


        System.out.println((float) big / sum);
        System.out.println((float) small / sum);
        System.out.println((float) equ / sum);
    }
}
