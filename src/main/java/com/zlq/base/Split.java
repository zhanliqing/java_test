package com.zlq.base;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liqing.zhan on 2017/2/8.
 */
public class Split {
    public static void main(String[] args) {
        String phone = "123456|789";
        List<String> phones = Arrays.asList(phone.split(""));
        System.out.println(phones);
    }
}
