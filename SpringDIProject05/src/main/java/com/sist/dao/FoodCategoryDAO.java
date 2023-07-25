package com.sist.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class FoodCategoryDAO extends SqlSessionDaoSupport {
	public List<FoodCategoryVO> foodCategoryListData(Map map) {
		return getSqlSession().selectList("foodCategoryListData", map);
	}
	
	public int foodCategoryTotalPage() {
		return getSqlSession().selectOne("foodCategoryTotalPage");
	}
	
	public List<FoodCategoryVO> foodCategoryFindData(String title) {
		return getSqlSession().selectList("foodCategoryFindData", title);
	}
	
}
