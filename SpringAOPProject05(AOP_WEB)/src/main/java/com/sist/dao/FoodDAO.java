package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	public List<CategoryVO> foodCategoryData() {
		return mapper.foodCategoryData();
	}
	
	public List<FoodVO> foodTop7() {
		return mapper.foodTop7();
	}
	
	public List<SeoulVO> seoulTop7() {
		return mapper.seoulTop7();
	}
}
