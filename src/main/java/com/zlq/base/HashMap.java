package com.zlq.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by liqing.zhan on 2017/6/12.
 */
public class HashMap {
    public static void main(String[] args) throws IOException, InterruptedException {
        Map<String, String> desc = new java.util.HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("d://abc/tt"))));
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) {
            if (line.trim().length() > 1) {
                desc.put("xian" + "_" + i++, line);
            }
        }

        System.out.println("out" + "----" + i);
        TimeUnit.SECONDS.sleep(10000);
    }
}
