package com.zlq.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by liqing.zhan on 2016/12/13.
 */
public class KylinParse {
    public static void main(String[] args) throws IOException {
        String line = new BufferedReader(new FileReader(new File("d://abc/kylin"))).readLine();
        JSONObject object = (JSONObject) JSON.parse(line);

        String content = object.getString("content");
        System.out.println(content);

        String sp[] = content.split("####");
        int i = 0;
        for (String s : sp) {
            System.out.println(i++ + "-----" + s);
        }
    }
}
