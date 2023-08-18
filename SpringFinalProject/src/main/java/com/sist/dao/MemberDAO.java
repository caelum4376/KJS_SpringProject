package com.sist.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.manager.*;
import com.sist.mapper.MemberMapper;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public int memberIdCheck(String id) {
		return mapper.memberIdCheck(id);
	}
	
	public int memberEmailCheck(String email) {
		return mapper.memberEmailCheck(email);
	}
	
	public void memberInsert(MemberVO vo) {
		mapper.memberInsert(vo);
	}
	
	public MemberVO memberInfoData(String id) {
		return mapper.memberInfoData(id);
	}
}
