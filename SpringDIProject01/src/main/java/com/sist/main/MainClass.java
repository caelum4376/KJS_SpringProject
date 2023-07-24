package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// XML 파싱 => 컨테이너에 등록
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		Sawon s1 = (Sawon)app.getBean("sa1");
		System.out.println("사번 : "+s1.getSabun());
		System.out.println("이름 : "+s1.getName());
		System.out.println("부서 : "+s1.getDept());
		System.out.println("직위 : "+s1.getJob());
		System.out.println("연봉 : "+s1.getPay());
		
		System.out.println("===================================");
		
		Sawon ss1 = app.getBean("sa1", Sawon.class);
		ss1.setSabun(2);
		ss1.setName("심청이");
		ss1.setDept("총무부");
		ss1.setJob("과장");
		ss1.setPay(4000);
		System.out.println("사번 : "+s1.getSabun());
		System.out.println("이름 : "+s1.getName());
		System.out.println("부서 : "+s1.getDept());
		System.out.println("직위 : "+s1.getJob());
		System.out.println("연봉 : "+s1.getPay());
		System.out.println("s1 : "+s1);
		System.out.println("ss1 : "+ss1);

		System.out.println("===================================");
		
		Sawon s2 = (Sawon)app.getBean("sa2");
		System.out.println("사번 : "+s2.getSabun());
		System.out.println("이름 : "+s2.getName());
		System.out.println("부서 : "+s2.getDept());
		System.out.println("직위 : "+s2.getJob());
		System.out.println("연봉 : "+s2.getPay());
		
		System.out.println("===================================");
		
		Sawon s3 = (Sawon)app.getBean("sa3");
		System.out.println("사번 : "+s3.getSabun());
		System.out.println("이름 : "+s3.getName());
		System.out.println("부서 : "+s3.getDept());
		System.out.println("직위 : "+s3.getJob());
		System.out.println("연봉 : "+s3.getPay());
		
	}

}
