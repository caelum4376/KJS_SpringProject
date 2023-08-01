package com.sist.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		BoardDAO dao = (BoardDAO)app.getBean("dao");
		dao.aopDelete("홍길동");
		dao.aopInsert("홍길동");
		dao.aopSelect("홍길동");
		dao.aopUpdate("홍길동");
		String name = dao.find("심청이");
	}
}
