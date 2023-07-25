package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	public static void seoul() {
		// Spring에 등록
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		SeoulDAO dao = (SeoulDAO)app.getBean("dao");
		int curpage = 1;
		Scanner scan = new Scanner(System.in);
		System.out.print("페이지 입력 : ");
		curpage = scan.nextInt();
		Map map = new HashMap();
		int rowSize = 10;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		System.out.println("=======서울 명소=======");
		List<SeoulLocationVO> list = dao.seoulListData(map);
		for (SeoulLocationVO vo:list) {
			System.out.println(vo.getNo() + "|"
							+ vo.getTitle() + "|"
							+ vo.getAddress() + "|");	
		}
		System.out.println("===================================");
		int totalpage = dao.seoulTotalPage();
		System.out.println("    " + curpage + " page / " + totalpage + " pages");
		System.out.println("===================================");
		System.out.print("검색어 입력 : ");
		String title = scan.next();
		List<SeoulLocationVO> fList = dao.seoulFindData(title);
		for (SeoulLocationVO vo:fList) {
			System.out.println(vo.getNo() + "|"
							+ vo.getTitle() + "|"
							+ vo.getAddress() + "|"
							+ vo.getMsg());	
		}
	}
	public static void foodcategory() {
		// Spring에 등록
		ApplicationContext app = new ClassPathXmlApplicationContext("app.xml");
		
		FoodCategoryDAO dao = (FoodCategoryDAO)app.getBean("fdao");
		int curpage = 1;
		Scanner scan = new Scanner(System.in);
		System.out.print("페이지 입력 : ");
		curpage = scan.nextInt();
		Map map = new HashMap();
		int rowSize = 10;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		System.out.println("====== ?=======");
		List<FoodCategoryVO> list = dao.foodCategoryListData(map);
		for (FoodCategoryVO vo:list) {
			System.out.println(vo.getCno() + "|"
					+ vo.getTitle() + "|"
					+ vo.getSubject() + "|");	
		}
		System.out.println("===================================");
		int totalpage = dao.foodCategoryTotalPage();
		System.out.println("    " + curpage + " page / " + totalpage + " pages");
		System.out.println("===================================");
		System.out.print("검색어 입력 : ");
		String title = scan.next();
		List<FoodCategoryVO> fList = dao.foodCategoryFindData(title);
		for (FoodCategoryVO vo:fList) {
			System.out.println(vo.getCno() + "|"
					+ vo.getTitle() + "|"
					+ vo.getSubject());	
		}
	}
	public static void main(String[] args) {
//		seoul();
		foodcategory();
	}
}
