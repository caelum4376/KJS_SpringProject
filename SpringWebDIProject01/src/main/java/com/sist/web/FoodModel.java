package com.sist.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
/*
 * 		client
 * 		  |
 * 		DispatcherServlet : 사용자의 모든 요청을 받는다(Front Controller)
 * 		  |					이미 스프링에서 라이브러리 제작
 * 		  |					=> 등록 (web.xml) => servlet은 구동 (톰캣)
 * 		  |				= HandlerAdapter : Model을 찾는 역할
 * 		  |				= HandlerMapping : 찾은 Model에서 @RequestMapping()
 * 		  |				----------------- DispatcherServlet설정과 동시에 설정
 * 		  |				*** 자바로 환경설정시에는 Handler~을 직접 설정
 * 		  |				==> web.xml에 셋팅과 동시에 구동
 * 		  |
 * 		해당모델 (Controller) : 개발자가 코딩하는 부분 => DAO
 * 		  | request에 요청처리 값을 담는다
 * 		  |	JSP파일명을 전송한다
 * 		  | Java => JSP로 전송(X)
 * 		  | JSP => JSP, Servlet ==> JSP
 * 		DispatcherServlet 
 * 		  | 1) JSP찾기
 * 		  | 2) request를 전송
 * 		  | ----------------- ViewResolver
 * 		View (JSP)
 * 		  | request에 담긴 데이터를 출력 (JSTL/EL)
 * 		Client (브라우저)
 */
// Model (요청 -> 응답)
@Controller
@RequestMapping("food/")
public class FoodModel {
	@Autowired
	private FoodDAO dao;
	
	@RequestMapping("category.do")
	public String food_category(HttpServletRequest request, HttpServletResponse response) {
		List<CategoryVO> list = dao.foodCategoryListData();
		request.setAttribute("list", list);
		return "food/category";
	}
	
	@RequestMapping("food_list.do")
	public String food_list(HttpServletRequest request, HttpServletResponse response) {
		String cno = request.getParameter("cno");
		List<FoodVO> list = dao.foodListData(Integer.parseInt(cno));
		request.setAttribute("list", list);
		return "food/list";
	}
}
