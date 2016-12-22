package com.zlq.guava.event;

import com.google.common.eventbus.Subscribe;

public class EventListener {
    public int lastMessage = 0;

    @Subscribe
    public void listen(TestEvent event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage);
    }

    @Subscribe
    public void listen1(Event1 event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage);
    }


    @Subscribe
    public void listen2(Event2 event) {
        lastMessage = event.getMessage();
        System.out.println("Message:" + lastMessage);
    }

}