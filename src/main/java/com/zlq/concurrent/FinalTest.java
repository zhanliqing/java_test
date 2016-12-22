package com.zlq.concurrent;

/**
 * Created by liqing.zhan on 2016/11/3.
 */
public class FinalTest {
    public static void main(String[] args) {
        new FinalTest().test();
    }

    public void test() {
        final int a = 10;
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(a);
            }
        }).start();
    }
}
