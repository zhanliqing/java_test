package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/8/15.
 */
public class BitTest {
    public static void main(String[] args) {
//        String s = "1111111111111111111111111111111";
//        System.out.println(Integer.valueOf(s, 2));

        int i = (int) 2147483644L;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(Integer.toBinaryString(i << 1));
        System.out.println(Integer.toBinaryString(i << 2));
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(1 << 33));
    }
}
