package com.zlq.concurrent;

/**
 * Created by liqing.zhan on 2016/7/20.
 * javap -verbose SynchorinizeTest
 */
public class SynchorinizeTest {
    private Integer t;

    /**
     * ACC_SYNCHRONIZED
     */
    public synchronized void print() {
        System.out.println();
    }

    public void add() {
        /**
         *monitorenter
         *monitorexit
         */
        synchronized (t) {
            t++;
        }
    }

}
