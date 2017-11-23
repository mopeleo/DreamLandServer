package com.dl.server.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContext{

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:spring/*.xml");

	private SpringContext(){}
	
	public static ApplicationContext getApplicationContext() {
		if (applicationContext == null)
			throw new IllegalStateException("applicaitonContext为空,请确认spring配置文件是否正确");
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		return (T) getApplicationContext().getBean(name);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		return (T) getApplicationContext().getBeansOfType(clazz);
	}
}
