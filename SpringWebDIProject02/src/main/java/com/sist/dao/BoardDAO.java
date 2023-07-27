package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class BoardDAO {
	@Autowired
	private BoardMapper mapper;
	
	// 목록 출력
//	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD'), hit, num "
//			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
//			+ "FROM (SELECT /*+ INDEX_DESC(springBoard sb_no_pk) */no, subject, name, regdate, hit "
//			+ "FROM springBoard)) "
//			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<BoardVO> boardListData(Map map) {
		return mapper.boardListData(map);
	}
	// 총페이지
//	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springBoard")
	public int boardTotalPage() {
		return mapper.boardTotalPage();
	}
	
	// 글 추가
//	@Insert("INSERT INTO springBoard(no, name, subject, content, pwd) "
//			+ "VALUES(sb_no_seq.nextval, #{name},#{subject},#{content},#{pwd})")
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}
	
	// 상세보기
//	@Select("SELECT * FROM springBoard "
//			+ "WHERE no = #{no}")
	public BoardVO boardDetailData(int no) {
		mapper.hitIncrement(no);
		return mapper.boardDetailData(no);
		
	}
}
