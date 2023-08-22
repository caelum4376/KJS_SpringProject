package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.*;
public interface DataBoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, num "
			+ "FROM (SELECT no, subject, name, regdate, hit, rownum as num "
			+ "FROM (SELECT no, subject, name, regdate, hit "
			+ "FROM springDataBoard ORDER BY no DESC)) "
			+ "WHERE num BETWEEN #{start} AND #{end}")
	public List<DataBoardVO> dataBoardListData(Map map);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springDataBoard")
	public int databoardTotalPage();
	
	@Insert("INSERT INTO springDataBoard VALUES("
			+ "sdb_no_seq.nextval, #{name}, #{subject}, #{content}, "
			+ "#{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
	public void dataBoardInsert(DataBoardVO vo);
	
	@Update("UPDATE springDataBoard SET "
			+ "hit = hit+1 "
			+ "WHERE no=#{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, TO_CHAR(regdate, 'YYYY-MM-DD') as dbday, hit, "
			+ "filename, filesize, filecount "
			+ "FROM springDataBoard "
			+ "WHERE no=#{no}")
	public DataBoardVO databoardDetailData(int no);
}
