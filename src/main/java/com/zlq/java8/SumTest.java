package com.zlq.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liqing.zhan on 2017/1/17.
 */
public class SumTest {
    public static void main(String[] args) {
        List<Double> doubleList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            doubleList.add(random.nextDouble());
        }

        double sum = doubleList.stream().reduce((aDouble, aDouble2) -> aDouble + aDouble2).get();


        System.out.println(sum);

        double sum1 = 0.0;
        for (double d : doubleList) {
            sum1 += d;
        }
        System.out.println(sum1);
    }
}
