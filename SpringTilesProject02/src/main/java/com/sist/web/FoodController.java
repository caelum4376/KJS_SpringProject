package com.sist.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.dao.FoodDAO;
import com.sist.vo.*;
@Controller
public class FoodController {
	@Autowired
	private FoodDAO dao;
	
	@GetMapping("food/food_list.do")
	public String food_list(int cno, Model model) {
		
		List<FoodVO> list = dao.foodListData(cno);
		for (FoodVO vo:list) {
			String address = vo.getAddress();
			address = address.substring(0, address.lastIndexOf("지번"));
			vo.setAddress(address);
			
			String poster = vo.getPoster();
			poster = poster.substring(0, poster.indexOf("^"));
			poster = poster.replace("#", "&");
			vo.setPoster(poster);
		}
		CategoryVO vo = dao.foodCategoryInfoData(cno);
		model.addAttribute("cvo", vo);
		model.addAttribute("list", list);
		return "food/food_list";
	}
}
