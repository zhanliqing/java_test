package com.zlq.guava.event;

import com.google.common.eventbus.EventBus;

/**
 * Created by liqing.zhan on 2016/11/2.
 */
public class EventTest {
    public static void main(String args[]) {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventListener());

        TestEvent event = new TestEvent(1111);
        eventBus.post(event);

        Event1 event1 = new Event1(22222);
        eventBus.post(event1);

        Event2 event2 = new Event2(33333);
        eventBus.post(event2);
    }
}
