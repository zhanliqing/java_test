package com.zlq.base.string;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2017/4/14.
 */
public class InternCache {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> tmp = Maps.newHashMap();
        for (int i = 0; i < 1000; i++) {
            tmp.put((i + ""), (i + ""));
        }

        TimeUnit.SECONDS.sleep(1000);

    }
}
