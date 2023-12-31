package com.sist.dao;

import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;
@Repository
public class SeoulDAO {
	@Autowired
	private SeoulMapper mapper;
	
	public List<SeoulVO> seoulListData(Map map) {
		return mapper.seoulListData(map);
	}
	
	public int seoulTotalPage(Map map) {
		return mapper.seoulTotalPage(map);
	}
	
}
