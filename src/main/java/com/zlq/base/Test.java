package com.zlq.base;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/11/15.
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        while (true) {
            int a = random.nextInt();
            p(random, a);
        }
    }


    public static void p(Random random, int a) throws InterruptedException {
        int second = random.nextInt(10);
        TimeUnit.SECONDS.sleep(second);
        System.out.println("p " + second);
    }
}
