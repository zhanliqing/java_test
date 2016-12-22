package com.zlq.guava.event;

/**
 * Created by liqing.zhan on 2016/11/2.
 */
public class Event1 {
    private final int message;

    public Event1(int message) {
        this.message = message;
        System.out.println("Event1 message:" + message);
    }

    public int getMessage() {
        return message;
    }
}
