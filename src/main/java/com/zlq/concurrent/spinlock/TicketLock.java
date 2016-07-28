package com.zlq.concurrent.spinlock;

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
    private AtomicInteger serviceNum = new AtomicInteger();

    private AtomicInteger ticketNum = new AtomicInteger();

    private ThreadLocal<Integer> myTicket = new ThreadLocal<>();

    public void lock() {
        int myNum = serviceNum.getAndIncrement();
        myTicket.set(myNum);
        while (myNum != ticketNum.get()) ;
    }

    public void unlock() {
        int next = myTicket.get() + 1;
        serviceNum.compareAndSet(myTicket.get(), next);
    }
}
