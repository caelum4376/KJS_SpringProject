package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sist.dao.MemberDAO;
import com.sist.vo.MemberVO;
/*
 * 		tiles
 * 		-----
 */
@Controller // 페이지 관리
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("member/join.do")
	public String member_join(Model model) {
		
		model.addAttribute("main_jsp", "../member/join.jsp");
		return "main/main";
	}

	@PostMapping("member/join_ok.do")
	public String member_join_ok(MemberVO vo) {
		vo.setPhone(vo.getPhone1()+"-"+vo.getPhone());
		String enPwd = encoder.encode(vo.getPwd());
		vo.setPwd(enPwd);
		dao.memberInsert(vo);
		return "redirect:../main/main.do";
	}
}
