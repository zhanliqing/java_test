package com.zlq.concurrent.master_slave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/7/19.
 */
public class Items {
    private List<String> items = new ArrayList(10);

    public void addItem(String e) {
        synchronized (items) {
            while (true) {
                if (items.size() < 10) {
                    items.add(e);
                    items.notifyAll();
                    break;
                } else {
                    try {
                        items.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }

    }

    public String getItem() {
        synchronized (items) {
            while (true) {
                if (items.size() != 0) {
                    String item = items.remove(0);

                    return item;
                } else {
                    try {
                        items.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
