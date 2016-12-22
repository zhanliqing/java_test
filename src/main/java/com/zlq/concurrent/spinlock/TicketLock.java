package com.zlq.concurrent.spinlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ticket Lock 是为了解决上面的公平性问题，类似于现实中银行柜台的排队叫号：
 * 锁拥有一个服务号，表示正在服务的线程，还有一个排队号；每个线程尝试获取锁之
 * 前先拿一个排队号，然后不断轮询锁的当前服务号是否是自己的排队号，如果是，则
 * 表示自己拥有了锁，不是则继续轮询。
 * 当线程释放锁时，将服务号加1，这样下一个线程看到这个变化，就退出自旋。
 * reference
 * http://coderbee.net/index.php/concurrent/20131115/577
 */
public class TicketLock {
    private AtomicInteger serviceNum = new AtomicInteger(); // 服务号
    private AtomicInteger ticketNum = new AtomicInteger(); // 排队
    private ThreadLocal<Integer> myTicket = new ThreadLocal<>();

    public void lock() {
        // 首先原子性地获得一个排队号
        int myTicketNum = ticketNum.getAndIncrement();

        // 只要当前服务号不是自己的就不断轮询
        while (serviceNum.get() != myTicketNum) {
        }

        myTicket.set(myTicketNum);
        System.out.println(Thread.currentThread().getName() + " acquire lock");
    }

    public void unlock() {
        int my = myTicket.get();
        // 只有当前线程拥有者才能释放锁
        int next = my + 1;
        if (serviceNum.compareAndSet(my, next)) {
            System.out.println(Thread.currentThread().getName() + " release lock");
        } else {
            throw new RuntimeException("error");
        }
    }

    static class Main {
        public static void main(String[] args) {
            TicketLock ticketLock = new TicketLock();
            new Thread(() -> {
                ticketLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticketLock.unlock();
            }).start();
            new Thread(() -> {
                ticketLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticketLock.unlock();
            }).start();
            new Thread(() -> {
                ticketLock.lock();
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ticketLock.unlock();
            }).start();
        }
    }
}
