package com.sist.main4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
	private Sawon sa;
	
	public Sawon getSa() {
		return sa;
	}

	public void setSa(Sawon sa) {
		this.sa = sa;
	}

	public static void main(String[] args) {
		ApplicationContext app1 = new ClassPathXmlApplicationContext("app4.xml");
		Sawon sa1 = (Sawon)app1.getBean("sa1");
		// sa.init()
		sa1.print();
		// sa.destory() (X)
		
		GenericXmlApplicationContext app2 = new GenericXmlApplicationContext("app4.xml");
		Sawon sa2 = (Sawon)app2.getBean("sa1");
		sa2.print();
		app2.close();
	}
}
