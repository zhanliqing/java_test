package com.zlq.reflect;

import org.hibernate.validator.internal.xml.ParameterType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liqing.zhan on 2016/12/22.
 */
public class ParameterizedTypeTest {
    private Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws NoSuchFieldException {
        Field field = ParameterizedTypeTest.class.getDeclaredField("map");
        System.out.println(field.getType().getName());
        System.out.println(field.getGenericType());

        System.out.println(field.getGenericType() instanceof ParameterType);
        ParameterizedType type = (ParameterizedType) field.getGenericType();
        System.out.println(type.getRawType());
        Arrays.asList(type.getActualTypeArguments()).forEach(System.out::println);
        System.out.println(type.getOwnerType());
    }
}
