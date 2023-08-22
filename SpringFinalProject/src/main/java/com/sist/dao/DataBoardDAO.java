package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.DataBoardVO;
@Repository
public class DataBoardDAO {
	@Autowired
	private DataBoardMapper mapper;
	
	public List<DataBoardVO> dataBoardListData(Map map) {
		return mapper.dataBoardListData(map);
	}
	
	public int databoardTotalPage() {
		return mapper.databoardTotalPage();
	}
	
	public void dataBoardInsert(DataBoardVO vo) {
		mapper.dataBoardInsert(vo);
	}
	
	public DataBoardVO databoardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}
}
