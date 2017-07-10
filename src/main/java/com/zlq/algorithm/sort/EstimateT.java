package com.zlq.algorithm.sort;

/**
 * Created by liqing.zhan on 2017/4/14.
 */
public class EstimateT {
    public static void main(String[] args) {
        int order1 = 5033;
        int uv1 = 17199;

        double mean1 = (double) order1 / uv1;

        int order2 = 4830;
        int uv2 = 17025;
        double mean2 = (double) order2 / uv2;

        double z = (mean1 - mean2) / Math.sqrt(uv1 * mean1 * (1 - mean1) + uv2 * mean2 * (1 - mean2));


        System.out.println(mean1 + "----" + mean2);
        System.out.println(z);
    }
}
