package com.zlq.guava.event;

import java.lang.reflect.ParameterizedType;

/**
 * 拿到泛型的类型
 *
 * @param <T>
 */

class Tmp<T> {

    private Class<T> eClass;

    public Tmp() {
        super();
    }

    public Class<T> getEClass() {
        return eClass;
    }

    public void setEClass(Class<T> eClass) {
        this.eClass = eClass;
    }

    static class Main {
        public static void main(String... args) {
            Tmp<String> tmp = new Tmp<>();
            tmp.getEClass();
        }
    }

}

class Tmp1 extends Tmp<String> {
    public Tmp1() {
        System.out.println((Class) ((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);
    }

    static class Main {
        public static void main(String... args) {
            Tmp1 tmp = new Tmp1();
            tmp.getEClass();
        }
    }
}


class Tmp2 {
    public Tmp<String> tmp = new Tmp();

    static class Main {
        public static void main(String... args) throws NoSuchFieldException {
            ParameterizedType type = (ParameterizedType) Tmp2.class.getField("tmp").getGenericType();
            System.out.println(type.getActualTypeArguments().length);
            System.out.println(type.getActualTypeArguments()[0]);

            Class clazz = (Class) type.getActualTypeArguments()[0];
            System.out.println(clazz.getName());

        }
    }
}
