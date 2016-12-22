package com.zlq.java8;

import java.util.Arrays;
import java.util.List;

/**
 * Created by liqing.zhan on 2016/11/15.
 */
public class Stream1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream().filter((x) -> x % 2 == 0).map((x) -> {
            System.out.println(x);
            return x * x;
        }).forEach(System.out::println);

        /*Supplier<Integer> supplier = new Supplier<Integer>() {
            int start = 0;

            @Override
            public Integer get() {
                System.out.println("dddd");
                return start++;
            }
        };
        Stream stream = Stream.generate(supplier);
        stream.limit(10).forEach(System.out::print);*/
    }
}
