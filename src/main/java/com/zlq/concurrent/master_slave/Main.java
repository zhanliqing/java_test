package com.zlq.concurrent.master_slave;

/**
 * Created by liqing.zhan on 2016/7/19.
 */
public class Main {
    public static void main(String args[]) {
        Items items = new Items();
        Master master = new Master(items);
        new Thread(() -> {
            Master m;
            {
                m = master;
            }

            m.generate();

        }).start();


        Slave slave = new Slave(items);
        new Thread(() -> {
            Slave s;
            {
                s = slave;
            }

            while (true) {
                System.out.println(Thread.currentThread().getName() + s.get());
            }

        }).start();
        new Thread(() -> {
            Slave s;
            {
                s = slave;
            }

            while (true) {
                System.out.println(Thread.currentThread().getName() + s.get());
            }

        }).start();
        new Thread(() -> {
            Slave s;
            {
                s = slave;
            }

            while (true) {
                System.out.println(Thread.currentThread().getName() + s.get());
            }

        }).start();
    }
}
