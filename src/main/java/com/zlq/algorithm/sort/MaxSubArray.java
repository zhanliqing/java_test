package com.zlq.algorithm.sort;

import java.util.Random;

/**
 * 求子数组之和最大值，并且给出范围
 * Created by liqing.zhan on 2017/7/10.
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int t[] = genData();
        System.out.println(maxData(t));
        System.out.println(maxData1(t));
    }

    static int maxData(int data[]) {
        int length = data.length;
        int f = length - 1, it = length - 1, t = length - 1;
        int iMax = data[length - 1];
        int nMax = data[length - 1];

        for (int r = length - 2; r >= 0; r--) {
            if (iMax < 0) {
                iMax = data[r];
                it = r;
            } else {
                iMax += data[r];
            }
            if (nMax < iMax) {
                nMax = iMax;
                f = r;
                t = it;
            }
        }
        System.out.println("from is " + f + " to is " + t);
        return nMax;
    }

    static int maxData1(int data[]) {
        int length = data.length;
        int iMax = data[0];
        int nMax = data[0];

        for (int r = 1; r < length; r++) {
            if (iMax < 0) {
                iMax = data[r];
            } else {
                iMax += data[r];
            }
            if (nMax < iMax) {
                nMax = iMax;
            }
        }
        return nMax;
    }


    static int[] genData() {
        int tmp[] = {-1, 0, 1, 2};
        int length = 16;
        int real[] = new int[length];
        Random random = new Random();
        int i = 0;
        while (i++ < length) {
            real[i - 1] = tmp[random.nextInt(tmp.length)];
        }
        for (i = 0; i < real.length; i++) {
            System.out.print(real[i] + " ");
        }

        System.out.println();
        return real;
    }
}
