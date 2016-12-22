package com.zlq.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by liqing.zhan on 2016/11/8.
 */
public class LockSupportTest {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                TimeUnit.SECONDS.sleep(5);
                LockSupport.unpark(thread);
                System.out.println(Thread.currentThread().getName() + " stop");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println(Thread.currentThread().getName() + " come");
        LockSupport.park(thread);
        System.out.println(Thread.currentThread().getName() + " end");
    }
}
