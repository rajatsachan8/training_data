package com.mindtree;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class MainApp {
	 public static void main(String[] args) {
	      ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
	      HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
	      obj.getMessage();
	      
	      Resource resource=new ClassPathResource("Beans.xml");  
	      BeanFactory factory=new XmlBeanFactory(resource);  
	      HelloWorld obj1=(HelloWorld)factory.getBean("helloWorld");
	      obj1.getMessage();
	   }
}
