package com.zlq.concurrent.spinlock;

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
        if (lockedThread.get() != null) {
            icr++;
            return;
        }

        for (; ; ) {
            if (lockedThread.compareAndSet(null, currentThread)) {
                break;
            }
        }
    }


    public void unlock() {
        Thread currentTherad = Thread.currentThread();
        if (lockedThread.get() != currentTherad) {
            throw new RuntimeException("not locked");
        }
        if (--icr == 0) {
            lockedThread.compareAndSet(Thread.currentThread(), null);
        }
    }
}
