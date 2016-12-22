package com.zlq.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/12/8.
 */
public class ForTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("" + i);
        }

        for (String s : list) {
            if (s.equals("4")) {
                list.remove(s);
            }
            System.out.println(s);
        }
    }
}
