package com.zlq.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 调用lazyset ，写线程写入成功后，读线程可能不会立即看到
 * <p>
 * Created by liqing.zhan on 2016/11/10.
 */
public class AtomicLazySetTest {
    public static AtomicLong status;

    static {
        status = new AtomicLong(10);
    }


    public static void main(String[] args) {
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();
        new Thread(() -> {
            while (status.get() != 0) {
                System.out.println(Thread.currentThread().getName() + "--" + status.get());
            }
        }).start();


        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            status.lazySet(0);
            System.out.println("set to 0");
            System.out.println(Thread.currentThread().getName() + "--" + status.get());
        }).start();
    }
}
