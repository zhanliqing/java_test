package com.zlq.base.Introspector;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by liqing.zhan on 2016/10/8.
 */
public class Introspector1 {
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String args[])
			throws IntrospectionException, InvocationTargetException, IllegalAccessException {
		Introspector1 introspector1 = new Introspector1();
		introspector1.setName("A");
		BeanInfo beanInfo = Introspector.getBeanInfo(Introspector1.class);

		PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < props.length; i++) {
			System.out.println(props[i].getName() + "=" + props[i].getReadMethod().invoke(introspector1, null));
		}
	}
}
