package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sist.mapper.*;
import com.sist.vo.*;

@RestController
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryListData(Map map) {
		return mapper.foodCategoryListData(map);
	}
	
	public List<FoodVO> foodListData(int cno) {
		return mapper.foodListData(cno);
	}
}
