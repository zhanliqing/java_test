package com.zlq.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/8/19.
 */
public class Collections {
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(0);
        list.add(-4);
        java.util.Collections.sort(list);
        list.forEach(x -> System.out.println(x));
    }
}
