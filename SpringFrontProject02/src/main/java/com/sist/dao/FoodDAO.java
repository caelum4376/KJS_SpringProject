package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class FoodDAO {
	@Autowired
	private FoodMapper mapper;
	
	// 목록
	public List<FoodLocationVO> foodListData(Map map) {
		return mapper.foodListData(map);
	}
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}
	
	// 상세
	public FoodLocationVO foodDetailData(int fno) {
		return mapper.foodDetailData(fno);
	}
	
	// 검색 ==> VueJS / ReactJS => 실시간
	public FoodLocationVO foodFindData(int fno) {
		return mapper.foodFindData(fno);
	}
}
