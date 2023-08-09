package com.sist.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.vo.*;

public interface FoodMapper {
	@Select({"<script>"
		+"SELECT cno, title, subject, poster "
		+ "FROM food_category "
		+ "WHERE "
		+ "<if test='cno==1'>"
		+ "cno BETWEEN 1 AND 12"
		+ "</if>"
		+ "<if test='cno==2'>"
		+ "cno BETWEEN 13 AND 18"
		+ "</if>"
		+ "<if test='cno==3'>"
		+ "cno BETWEEN 19 AND 30"
		+ "</if>"
		+ " ORDER BY cno ASC"
		+ "</script>"
	})
	public List<CategoryVO> foodCategoryListData(Map map);
	
	@GetMapping("SELECT fno, name, poster, type, phone, address "
			+ "FROM food_house "
			+ "WHERE cno=#{cno}")
	public List<FoodVO> foodListData(int cno);
	
}
