package com.sist.main;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.LocationDAO;
import com.sist.dao.NatureDAO;
import com.sist.dao.ShopDAO;
import com.sist.vo.*;
public class MainClass {

	public static void main(String[] args) {
		
	}
	
	@Test
	public void location() {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao = (LocationDAO)app.getBean("ldao"); 
		List<SeoulLocationVO> list = dao.locationListData();
		for (SeoulLocationVO vo:list) {
			System.out.println(vo.getNo()+ "|" + vo.getTitle());
		}
	}
	
	@Test
	public void locationDetail() {
		int no = 1;
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		LocationDAO dao = (LocationDAO)app.getBean("ldao");
		SeoulLocationVO vo = dao.locationDetailData(no);
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Address : "+vo.getAddress());
		System.out.println("Message : "+vo.getMsg());
		
	}
	
	@Test
	public void shop() {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao = (ShopDAO)app.getBean("sdao"); 
		List<SeoulShopVO> list = dao.shopListData();
		for (SeoulShopVO vo:list) {
			System.out.println(vo.getNo()+ "|" + vo.getTitle());
		}
	}
	
	@Test
	public void shopDetail() {
		int no = 1;
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		ShopDAO dao = (ShopDAO)app.getBean("sdao");
		SeoulShopVO vo = dao.shopDetailData(no);
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Address : "+vo.getAddress());
		System.out.println("Message : "+vo.getMsg());
		
	}
	
	@Test
	public void nature() {
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		NatureDAO dao = (NatureDAO)app.getBean("ndao"); 
		List<SeoulNatureVO> list = dao.natureListData();
		for (SeoulNatureVO vo:list) {
			System.out.println(vo.getNo()+ "|" + vo.getTitle());
		}
	}
	
	@Test
	public void natureDetail() {
		int no = 1;
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		NatureDAO dao = (NatureDAO)app.getBean("ndao");
		SeoulNatureVO vo = dao.natureDetailData(no);
		System.out.println("Title : "+vo.getTitle());
		System.out.println("Address : "+vo.getAddress());
		System.out.println("Message : "+vo.getMsg());
		
	}

}
