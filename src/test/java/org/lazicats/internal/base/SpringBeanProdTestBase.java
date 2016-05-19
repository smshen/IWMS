package org.lazicats.internal.base;

import org.junit.BeforeClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanProdTestBase {
	private static ApplicationContext  ac;
	
	@BeforeClass
	public  static void init(){
		 ac = new ClassPathXmlApplicationContext("applicationContext.prod.xml");
	}
	

	protected <T> T get(String name) throws Exception {
		  return (T) ac.getBean(name);
	}
	
	protected static <T> T get(Class<?> clz) throws Exception {
		  return (T) ac.getBean(clz);
	}
	
}
