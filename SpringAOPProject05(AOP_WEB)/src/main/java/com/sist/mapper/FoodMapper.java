package com.sist.mapper;
import java.util.*;
import com.sist.vo.*;
import org.apache.ibatis.annotations.Select;
public interface FoodMapper {
	@Select("SELECT cno, title, poster FROM food_category ORDER BY cno ASC")
	public List<CategoryVO> foodCategoryData();
	
	@Select("SELECT fno, name, poster, rownum "
			+ "FROM (SELECT fno, name, poster "
			+ "FROM food_house ORDER BY fno ASC) "
			+ "WHERE rownum <= 7")
	public List<FoodVO> foodTop7();
	
	@Select("SELECT no, title, poster, rownum "
			+ "FROM (SELECT no, title, poster "
			+ "FROM seoul_location ORDER BY no ASC) "
			+ "WHERE rownum <= 7")
	public List<SeoulVO> seoulTop7();
}
