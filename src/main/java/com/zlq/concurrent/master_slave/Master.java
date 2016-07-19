package com.zlq.concurrent.master_slave;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2016/7/19.
 */
public class Master {
    private Items items;

    public Master(Items items) {
        this.items = items;
    }


    public void generate() {
        int count = 100;
        Random random = new Random();
        while (count-- > 0) {
            items.addItem("master" + random.nextInt(1000));
            System.out.println("generate");
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
