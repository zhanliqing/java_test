package com.zlq.concurrent.master_slave;

/**
 * Created by liqing.zhan on 2016/7/19.
 */
public class Slave {
    private Items items;

    public Slave(Items items) {
        this.items = items;
    }

    public String get() {
        return items.getItem();
    }
}
