package com.zlq.concurrent;

/**
 * Created by liqing.zhan on 2016/11/3.
 */
public class VolatileTest {
    public int a = 0;
    public volatile boolean flag = false;

    public void setA() {
        a = 1;
        flag = true;
    }

    public void getA() {
        if (flag) {
            System.out.println(a * a);
        }
    }


    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        new Thread(() -> test.getA()).start();
        new Thread(() -> test.setA()).start();
    }
}
