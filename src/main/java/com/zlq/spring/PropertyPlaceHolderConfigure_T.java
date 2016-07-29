package com.zlq.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by liqing.zhan on 2016/7/29.
 */
public class PropertyPlaceHolderConfigure_T {
	public static void main(String args[]) throws IOException {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		PropertyBean propertyBean = (PropertyBean) applicationContext.getBean("propertyBean");
		System.out.println(propertyBean.getJdbc().trim());
	}
}
