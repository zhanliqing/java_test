package com.zlq.concurrent.master_slave;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/7/19.
 */
public class ArrayCopyTest {
    public static void main(String args[]) {
        List<String> list = new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }

        List<String> list1 = new ArrayList<>(20);
        // only for array not for list
        System.arraycopy(list, 1, list1, 0, list.size() - 2);

        System.out.println(list1.size());
        list1.forEach(x -> System.out.println(x));

    }
}
