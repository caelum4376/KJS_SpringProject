package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;
import org.apache.ibatis.annotations.Select;

public interface EmpMapper {
	@Select("SELECT empno, ename, job, hiredate, sal "
			+ "FROM emp")
	public List<EmpVO> empListData();
	
	@Select("SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') as dbday, sal, deptno, comm "
			+ "FROM emp "
			+ "WHERE empno=#{empno}")
	public EmpVO empDetailData(int empno);
}
