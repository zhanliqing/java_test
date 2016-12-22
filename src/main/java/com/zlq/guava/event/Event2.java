package com.zlq.guava.event;

/**
 * Created by liqing.zhan on 2016/11/2.
 */
public class Event2 {
    private final int message;

    public Event2(int message) {
        this.message = message;
        System.out.println("Event2 message:" + message);
    }

    public int getMessage() {
        return message;
    }
}
