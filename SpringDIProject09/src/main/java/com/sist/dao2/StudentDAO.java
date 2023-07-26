package com.sist.dao2;
import java.util.*;

import com.sist.dao2.*;
public class StudentDAO {
	private StudentMapper mapper;
	
	public void setMapper(StudentMapper mapper) {
		this.mapper = mapper;
	}
	// 목록 읽기
	public List<StudentVO> studentListData() {
		return mapper.studentListData();
	}
	// 상세보기
	public StudentVO studentDetailData(int hakbun) {
		return mapper.studentDetailData(hakbun);
	}
	
	// 검색
	public List<StudentVO> studentFindData(String name) {
		return mapper.studentFindData(name);
	}
	
	// 추가
	public void studentInsert(StudentVO vo) {
		mapper.studentInsert(vo);
	}
	
	// 수정
	public void studentUpdate(StudentVO vo) {
		mapper.studentUpdate(vo);;
	}
	
	// 삭제
	public void studentDelete(int hakbun) {
		mapper.studentDelete(hakbun);
	}
}
