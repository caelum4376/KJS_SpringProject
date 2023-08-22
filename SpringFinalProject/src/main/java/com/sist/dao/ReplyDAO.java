package com.sist.dao;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;
@Repository
public class ReplyDAO {
	@Autowired
	private ReplyMapper mapper;
	
	public List<ReplyVO> replyListData(int fno) {
		return mapper.replyListData(fno);
	}
	
	public void replyInsert(ReplyVO vo) {
		mapper.replyInsert(vo);
	}
	
	public ReplyVO foodReplyData(int fno) {
		return mapper.foodReplyData(fno);
	}

	public int foodReplyCount(int fno) {
		return mapper.foodReplyCount(fno);
	}
	
	public void replyUpdate(ReplyVO vo) {
		mapper.replyUpdate(vo);
	}
	
	public void replyDelete(int no) {
		mapper.replyDelete(no);
	}
	
	
}
