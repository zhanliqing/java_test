package com.zlq.guava.event;

import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;

public class GenericClass<T> {                // 1
    private List<T> list;                     // 2
    private Map<String, T> map;               // 3

    public <U> U genericMethod(Map<T, U> m) { // 4
        return null;
    }

    public static void main(String... args) {
        GenericClass<Integer> genericClass = new GenericClass<Integer>();
        TypeVariable typeVariable[] = genericClass.getClass().getTypeParameters();
        System.out.println(typeVariable[0].getName());
    }
}  