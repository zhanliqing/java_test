package com.zlq.concurrent.spinlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by liqing.zhan on 2016/7/19.
 * 可重入自旋锁
 */
public class SpinLock {
    private AtomicReference<Thread> lockedThread = new AtomicReference<>();
    private int icr = 0;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        if (lockedThread.get() != null && currentThread == lockedThread.get()) {
            icr++;
            System.out.println(icr);
            return;
        }

        for (; ; ) {
            if (lockedThread.compareAndSet(null, currentThread)) {
                icr++;
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " acquire lock");
    }


    public void unlock() {
        Thread currentTherad = Thread.currentThread();
        if (lockedThread.get() != currentTherad) {
            throw new RuntimeException("not locked");
        }
        if (--icr == 0) {
            System.out.println(Thread.currentThread().getName() + " release lock");
            lockedThread.compareAndSet(Thread.currentThread(), null);
        }
    }

    static class Main {
        public static void main(String[] args) {
            SpinLock spinLock = new SpinLock();
            new Thread(() -> {
                spinLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                    spinLock.lock();
                    TimeUnit.SECONDS.sleep(5);
                    spinLock.unlock();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLock.unlock();
            }).start();
            new Thread(() -> {
                spinLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                    spinLock.lock();
                    TimeUnit.SECONDS.sleep(5);
                    spinLock.unlock();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLock.unlock();
            }).start();
            new Thread(() -> {
                spinLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                    spinLock.lock();
                    TimeUnit.SECONDS.sleep(5);
                    spinLock.unlock();
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spinLock.unlock();
            }).start();
        }
    }
}
