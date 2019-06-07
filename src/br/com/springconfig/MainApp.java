package br.com.springconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   
	private static ApplicationContext context;

	public static void main(String[] args) {
    	context = new ClassPathXmlApplicationContext("application-context.xml");
    	AppContext appContext = (AppContext) context.getBean("configSpring");
    	appContext.getMessage();
	}
	
}