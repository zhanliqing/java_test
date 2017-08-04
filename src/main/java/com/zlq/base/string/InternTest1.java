package com.zlq.base.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2017/3/3.
 */
public class InternTest1 {
    private static int step = 0;

    public static void main(String[] args) {
        Random random = new Random();
        init();
        for (; ; ) {
            Map<String, String> map = new HashMap<>();
            for (int i = 0; i < 100000; i++) {
                map.put(("tttddddddddddddddddddddddddt" + i).intern(), random.nextInt() + "");
            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(step++);
            /*if (step == 2) {
                return;
            }*/

            long start = System.currentTimeMillis();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                entry.getValue().intern();
                entry.getKey().intern();
            }
            System.out.println(System.currentTimeMillis() - start);
            return;
        }
    }

    public static void init() {
        for (int i = 0; i < 100000; i++) {
            ("tttddddddddddddddddddddddddt" + i).intern();
        }
    }
}
