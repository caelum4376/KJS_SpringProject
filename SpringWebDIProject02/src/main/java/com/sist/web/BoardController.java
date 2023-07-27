package com.sist.web;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// 메모리 할당
@Controller
@RequestMapping("board/")
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	// 목록
	@GetMapping("list.do")
	public String board_list(String page, Model model) {
		// Model model => 전송 객체 (request대신 사용)
		if (page==null)
			page = "1";
		Map map = new HashMap();
		int curpage = Integer.parseInt(page);
		int rowSize = 10;
		int start = (rowSize*curpage)-(rowSize-1);
		int end = rowSize*curpage;
		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list = dao.boardListData(map);
		int totalpage = dao.boardTotalPage();
		
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		model.addAttribute("list", list);
		return "board/list";
	}
	
	// 데이터 추가
	@GetMapping("insert.do")
	public String board_insert() {
		
		return "board/insert";
	}
	@PostMapping("insert_ok.do")
	public String board_insert_ok(BoardVO vo) {
		dao.boardInsert(vo);
		return "redirect:list.do";
	}
	
	// 데이터 수정
	
	
	// 데이터 삭제
	
	
	// 상세보기
	/*
	 * 		class Model {
	 * 			HttpSevletRequest request;
	 * 			public void addAttribute(String key, Object obj) {
	 * 				request.setAttribute(key, obj)
	 * 			}
	 * 		}
	 */
	@GetMapping("detail.do")
	public String board_detail(int no, Model model) {
		BoardVO vo = new BoardVO();
		vo = dao.boardDetailData(no);
		
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	
	// 검색 ==> 동적 쿼리
}
